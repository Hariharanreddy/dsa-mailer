Here’s the **fully updated `README.md`** reflecting the *latest changes* — including:

* Brevo **Transactional Email API** (not SMTP or campaign),
* **Express.js server** with `/run-cron` route,
* Both **sender and receiver email same**,
* Hosted on **Render**, triggered via **external cron** (e.g., cron-job.org),
* Uses `.txt` log instead of database.

---

````markdown
# DSA-Mailer 📧

A lightweight Express.js app that **emails 3 Java DSA questions daily** using the Brevo (Sendinblue) Transactional Email API. Hosted for free on Render and triggered via external cron.

---

## 📁 Features

- Sends **3 `.java` files daily** as email content
- Scans all nested files inside `dsa_questions/`
- Skips already sent files (tracked in `sent_log.txt`)
- Easy to self-host + run via `/run-cron` route
- No DB — uses plain `.txt` log for tracking

---

## 🛠 Setup Instructions

### 1. Clone the Repo

```bash
git clone https://github.com/yourusername/dsa-mailer.git
cd dsa-mailer
````

### 2. Install Dependencies

```bash
npm install
```

### 3. Configure Environment

Create a `.env` file:

```bash
cp .env.example .env
```

Then add your credentials:

```
PORT=3000
BREVO_API_KEY=your_brevo_api_key
YOUR_EMAIL=your_verified_email@example.com
```

> ✅ Both sender and receiver will be `YOUR_EMAIL`.

---

## 🚀 Run Locally

```bash
node index.js
```

Visit in browser:

```
http://localhost:3000/run-cron
```

It will:

* Pick the next 3 unsent `.java` files
* Email them to you via Brevo
* Log them in `sent_log.txt`

---

## ☁️ Deploy on Render (Free Tier)

1. Connect GitHub → Render → New Web Service
2. Add environment variables:

   * `BREVO_API_KEY`
   * `YOUR_EMAIL`
   * `PORT`
3. Build Command: `npm install`
4. Start Command: `node index.js`

Render URL will look like:

```
https://dsa-mailer.onrender.com/run-cron
```

---

## ⏰ Schedule Daily Cron (3 AM IST)

Use [cron-job.org](https://cron-job.org):

* URL: `https://<your-app>.onrender.com/run-cron`
* Schedule: `Daily at 3:00 AM IST`

No database, no backend state — simple `.txt` based tracking.

---

## 📇 How It Works

1. Reads all `.java` files in `dsa_questions/` (recursively)
2. Sorts them lexicographically
3. Skips already-sent files (from `sent_log.txt`)
4. Emails next 3 files as HTML content using Brevo Transactional API
5. Appends sent filenames to `sent_log.txt`

---

## 🔧 Customization

* Change number of questions per day:

  ```js
  const QUESTIONS_PER_DAY = 3;
  ```
* Add `/status` route to return `sent_log.txt`
* Add retry or delivery failure handling

---

## 📂 Folder Structure

```
.
├── dsa_questions/       # Your .java files (can be nested)
├── sent_log.txt         # Tracks which files are sent
├── .env                 # Your config (not committed)
├── index.js             # Main Express + mailing logic
└── README.md
```

---

## 🔐 Requirements

* Brevo ([https://www.brevo.com/](https://www.brevo.com/)) account
* Use Brevo's **Transactional API key**
* Verify your email in Brevo dashboard

---

## 🧪 API Routes

| Route            | Description                     |
| ---------------- | ------------------------------- |
| `/run-cron`      | Triggers mail with next 3 files |
| `/` or `/health` | Returns "DSA Mailer is running" |

---

## 📞 Need Help?

Open an issue or ping me — happy to help you set this up!

```

Let me know if you'd like this saved into a real `README.md` and zipped with the project files.
```
