// dsa-mailer/index.js
require("dotenv").config();
const express = require("express");
const fs = require("fs"); 
const path = require("path");
const mongoose = require("mongoose");
const SibApiV3Sdk = require("sib-api-v3-sdk");
 
const app = express(); 
const PORT = process.env.PORT || 3000;
  
// MongoDB Setup
mongoose.connect(process.env.MONGODB_URI, {
  useNewUrlParser: true, 
  useUnifiedTopology: true
}).then(() => console.log("Connected to MongoDB"))
  .catch(err => {
    console.error("MongoDB connection error:", err);
    process.exit(1);
  });


const sentFileSchema = new mongoose.Schema({ path: String });
const SentFile = mongoose.model("SentFile", sentFileSchema);

// Brevo API setup
const defaultClient = SibApiV3Sdk.ApiClient.instance;
defaultClient.authentications["api-key"].apiKey = process.env.BREVO_API_KEY;
const apiInstance = new SibApiV3Sdk.TransactionalEmailsApi();

const QUESTIONS_DIR = path.join(__dirname, "java-output");

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

// Read Java file contents
function getFileContents(filePaths) {
  return filePaths.map(filePath => {
    return `<h3>${path.basename(filePath)}</h3><pre>${fs.readFileSync(filePath, "utf-8")}</pre>`;
  }).join("<hr>");
}

// Select next 3 unsent questions
async function getNextQuestions(count = 3) {
  const allFiles = getAllJavaFiles(QUESTIONS_DIR);
  const sentDocs = await SentFile.find().sort({ _id: -1 }).limit(3);
  console.log("Sent documents:", sentDocs);
  const sentPaths = new Set(sentDocs.map(doc => doc.path));
  const unsentFiles = allFiles.filter(file => !sentPaths.has(file));
  return unsentFiles.slice(0, count);
}

// Save sent file paths to MongoDB
async function saveSentLog(filePaths) {
  const entries = filePaths.map(fp => ({ path: fp }));
  await SentFile.insertMany(entries);
}

// Send the email using Brevo API
async function sendEmailWithQuestions() {
  const filesToSend = await getNextQuestions();
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
    await saveSentLog(filesToSend);
    return `Sent ${filesToSend.length} questions.`;
  } catch (error) {
    console.error("Failed to send email:", error);
    return "Error occurred while sending email.";
  }
}

// Express routes
app.get("/send-dsa", async (req, res) => {
  const result = await sendEmailWithQuestions();
  res.send(result);
});

app.get("/", (req, res) => {
  res.send(`
    <h1>DSA Mailer Working Properly</h1>
    <p>Use the endpoint <a href="/send-dsa">/send-dsa</a> to send your daily DSA questions.</p>
  `);
});

app.listen(PORT, () => {
  console.log(`✅ DSA Mailer running on http://localhost:${PORT}`);
});
