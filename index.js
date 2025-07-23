// dsa-mailer/index.js
require("dotenv").config();
const express = require("express");
const fs = require("fs");
const path = require("path");
const SibApiV3Sdk = require("sib-api-v3-sdk");

const app = express();
const PORT = process.env.PORT || 3000;

// Brevo API setup
const defaultClient = SibApiV3Sdk.ApiClient.instance;
defaultClient.authentications["api-key"].apiKey = process.env.BREVO_API_KEY;
const apiInstance = new SibApiV3Sdk.TransactionalEmailsApi();

const QUESTIONS_DIR = path.join(__dirname, "java-output");
const SENT_LOG_FILE = path.join(__dirname, "sent-log.txt");

// Load sent log
function loadSentLog() {
  if (!fs.existsSync(SENT_LOG_FILE)) return [];
  const content = fs.readFileSync(SENT_LOG_FILE, "utf-8");
  return content.split("\n").filter(Boolean);
}

// Save to log
function appendToSentLog(filePaths) {
  fs.appendFileSync(SENT_LOG_FILE, filePaths.join("\n") + "\n");
}

// Recursively collect all Java file paths
function getAllJavaFiles(dir) {
  let results = [];
  fs.readdirSync(dir).forEach(file => {
    const fullPath = path.join(dir, file);
    if (fs.statSync(fullPath).isDirectory()) {
      results = results.concat(getAllJavaFiles(fullPath));
    } else if (file.endsWith(".java")) {
      results.push(fullPath);
    }
  });
  return results;
}

// Select next 3 unsent questions
function getNextQuestions(count = 3) {
  const allFiles = getAllJavaFiles(QUESTIONS_DIR);
  const sentFiles = new Set(loadSentLog());
  const unsentFiles = allFiles.filter(file => !sentFiles.has(file));
  return unsentFiles.slice(0, count);
}

// Read Java file contents
function getFileContents(filePaths) {
  return filePaths.map(filePath => {
    return `<h3>${path.basename(filePath)}</h3><pre>${fs.readFileSync(filePath, "utf-8")}</pre>`;
  }).join("<hr>");
}

// Send the email using Brevo API
async function sendEmailWithQuestions() {
  const filesToSend = getNextQuestions();
  if (filesToSend.length === 0) return "No new questions to send.";

  const emailBody = getFileContents(filesToSend);
  const sendSmtpEmail = {
    to: [{ email: process.env.YOUR_EMAIL }],
    sender: { name: "DSA Bot", email: process.env.YOUR_EMAIL },
    subject: "Your Daily DSA Questions",
    htmlContent: `<div>${emailBody}</div>`
  };

  try {
    await apiInstance.sendTransacEmail(sendSmtpEmail);
    appendToSentLog(filesToSend);
    return `Sent ${filesToSend.length} questions.`;
  } catch (error) {
    console.error("Failed to send email:", error);
    return "Error occurred while sending email.";
  }
}

// Express route to trigger manually
app.get("/send-dsa", async (req, res) => {
  const result = await sendEmailWithQuestions();
  res.send(result);
});

app.get("/", async (req, res) => {
  res.send(`
    <h1>DSA Mailer Working properly</h1>
    <p>Use the endpoint <a href="/send-dsa">/send-dsa</a> to send your daily DSA questions.</p>
  `);
});

app.listen(PORT, () => {
  console.log(`DSA Mailer running on http://localhost:${PORT}`);
});
