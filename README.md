# DSA-Mailer 📧

A lightweight Express.js app that **emails 3 Java DSA questions daily** using the Brevo (Sendinblue) Transactional Email API. Hosted for free on Render and triggered via external cron.

---

## 📁 Features

- Sends **3 `.java` files daily** as email content
- Scans all nested files inside `dsa_questions/`
- Tracks sent files using both:
  - ✅ `sent_log.txt`
  - ✅ MongoDB `SentFile` collection (with timestamp)
- Fetches latest sent files via MongoDB for display/logging
- No campaign or SMTP — uses Brevo **Transactional Email API**

---

## 🛠 Setup Instructions

### 1. Clone the Repo

```bash
git clone https://github.com/yourusername/dsa-mailer.git
cd dsa-mailer
```

### 2. Install Dependencies

```bash
npm install
```

### 3. Configure Environment

Create a `.env` file:

```bash
cp .env.example .env
```

Then fill in:

```
PORT=3000
BREVO_API_KEY=your_brevo_api_key
YOUR_EMAIL=your_verified_email@example.com
MONGODB_URI=your_mongodb_connection_string
```

> ✅ Both sender and receiver will be `YOUR_EMAIL`.

---

## 🚀 Run Locally

```bash
node index.js
```

Open in browser:

```
http://localhost:3000/send-dsa
```

The app will:

* Pick the next 3 unsent `.java` files
* Email them to you via Brevo
* Track them in both:
  - `sent_log.txt`
  - MongoDB `SentFile` collection

---

## ☁️ Deploy on Render (Free Tier)

1. Connect GitHub → Render → New Web Service
2. Add environment variables:

   - `BREVO_API_KEY`
   - `YOUR_EMAIL`
   - `MONGODB_URI`
   - `PORT`
3. Build Command: `npm install`
4. Start Command: `node index.js`

Render URL will look like:

```
https://dsa-mailer.onrender.com/send-dsa
```

---

## ⏰ Schedule Daily Cron (3 AM IST)

Use [cron-job.org](https://cron-job.org):

- URL: `https://<your-app>.onrender.com/send-dsa`
- Schedule: Daily at **3:00 AM IST**

Simple tracking — no DB migrations needed.

---

## 📇 How It Works

1. Reads all `.java` files in `dsa_questions/` (recursively)
2. Sorts them lexicographically
3. Skips already-sent files (from both log and MongoDB)
4. Emails next 3 files using Brevo Transactional API
5. Logs them in:
   - `sent_log.txt`
   - MongoDB `SentFile` with `{ filePath, sentAt }`

---

## 🔧 Customization

- Change number of questions per day:

  ```js
  const QUESTIONS_PER_DAY = 3;
  ```

- Mongo query for latest 3 sent files:

  ```js
  SentFile.find().sort({ _id: -1 }).limit(3);
  ```


---

## 📂 Folder Structure

```
.
├── dsa_questions/       # Your .java files (can be nested)
├── sent_log.txt         # Text-based log of sent files
├── models/SentFile.js   # Mongoose schema for tracking
├── .env                 # Your config (not committed)
├── index.js             # Main Express + mailing logic
└── README.md
```

---

## 🔐 Requirements

- Brevo ([https://www.brevo.com/](https://www.brevo.com/)) account
- MongoDB (Atlas or local)
- Brevo **Transactional API Key**
- Verified email in Brevo dashboard

---

## 🧪 API Routes

| Route            | Description                          |
| ---------------- | ------------------------------------ |
| `/send-dsa`      | Triggers mail with next 3 files      |
| `/`              | Returns "DSA Mailer is running"      |


---

## 🧠 Tech Stack

- **Express.js** (Node backend)
- **Brevo Transactional API** for emails
- **MongoDB** (via Mongoose)
- **Render** for hosting
- **cron-job.org** for scheduling

---

## 📞 Need Help?

Open an issue or ping me — happy to help you set this up!

