require("dotenv").config();
const fs = require("fs");
const path = require("path");
const nodemailer = require("nodemailer");
const express = require("express");
const app = express();

const PORT = process.env.PORT || 3000;
const DSA_FOLDER = "./dsa_questions";
const LOG_FILE = "./sent_log.txt";
const QUESTIONS_PER_DAY = 3;

const transporter = nodemailer.createTransport({
  host: "smtp-relay.brevo.com",
  port: 587,
  secure: false,
  auth: {
    user: process.env.FROM_EMAIL,
    pass: process.env.BREVO_API_KEY,
  },
});

function getAllJavaFiles(dirPath, array = []) {
  fs.readdirSync(dirPath).forEach(f => {
    const full = path.join(dirPath, f);
    if (fs.statSync(full).isDirectory()) getAllJavaFiles(full, array);
    else if (f.endsWith(".java")) array.push(full);
  });
  return array;
}

function readSentLog() {
  if (!fs.existsSync(LOG_FILE)) return [];
  return fs.readFileSync(LOG_FILE, "utf8")
    .split("\n").filter(Boolean);
}

function updateLog(files) {
  fs.appendFileSync(LOG_FILE, files.join("\n") + "\n");
}

function formatEmailBody(items) {
  return items.map(({ file, content }, i) =>
    `<h3>Q${i+1}: ${path.basename(file)}</h3>
     <pre style="background:#f4f4f4;padding:10px;">${content}</pre><br>`
  ).join("");
}

async function sendNextDSAQuestions() {
  const all = getAllJavaFiles(DSA_FOLDER).sort();
  const sent = readSentLog();
  const remaining = all.filter(f => !sent.includes(f));
  const today = remaining.slice(0, QUESTIONS_PER_DAY);
  if (today.length === 0) return "✅ All questions have been sent!";
  const items = today.map(f => ({ file: f, content: fs.readFileSync(f, "utf8") }));
  const html = formatEmailBody(items);
  await transporter.sendMail({
    from: process.env.FROM_EMAIL,
    to: process.env.TO_EMAIL,
    subject: "🧠 Daily 3 DSA Questions",
    html
  });
  updateLog(today);
  return `✅ Email sent with ${today.length} questions.`;
}

app.get("/run-cron", async (req, res) => {
  try {
    const msg = await sendNextDSAQuestions();
    res.send(msg);
  } catch (err) {
    console.error(err);
    res.status(500).send("Internal Error");
  }
});

app.get("/", (req, res) => res.send("DSA Mailer is running. Use /run-cron to trigger."));
app.listen(PORT, () => console.log(`Server up on port ${PORT}`));
