# DSA-Mailer

Automatically sends **3 Java DSA questions daily** via email using Brevo SMTP. Hosted as an Express app on Render, triggered via an external cron.

## ⚙️ Setup

1. **Clone repo**  
   ```bash
   git clone https://github.com/yourusername/dsa-mailer.git
   cd dsa-mailer
   ```

2. **Install dependencies**  
   ```bash
   npm install
   ```

3. **Copy & update `.env`**  
   ```bash
   cp .env.example .env
   ```
   Fill in your Brevo SMTP API key and email addresses.

4. **Add Java files** under `dsa_questions/` (any nested structure).

## 🚀 Run Locally

```bash
node index.js
```

Visit `http://localhost:3000/run-cron` to send the next 3 questions manually.

## ☁️ Deploy on Render (Free Tier)

- Create a **New Web Service** from GitHub.
- Use `npm install` & `node index.js`.
- Add environment variables from your `.env`.

## ⏰ Schedule Daily Trigger at 3 AM IST

Use a free cron-service like **cron-job.org**:

- URL: `https://<your-app>.onrender.com/run-cron`
- Schedule: daily at **3:00 AM** IST

## 📇 How it Works

- Scans `dsa_questions/` recursively.
- Logs sent files in `sent_log.txt`.
- Sends next 3 files in lex order via email.
- Continues next day, until all files are sent.

## 🔧 Customization

- Change number of questions per day in `index.js` (adjust `QUESTIONS_PER_DAY`).
- Add `/status` endpoint to view log.
- Add retry/failover logic for unstable SMTP.

## 📞 Questions? 
Feel free to open an issue or reach out!
