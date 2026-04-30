# 📱 Spam Detection System (Spring Boot + Python ML)

A full-stack spam detection and reporting system that integrates a **Spring Boot backend**, a **Python ML model**, and a **MongoDB database**, with a simple frontend interface.

<!- this project works with in parallel to another git repo Spam-Ham-SMS , for prediction->

---

## 🚀 Features

* 🔍 **Spam Prediction**

  * Uses a Python ML model to classify messages as spam or not.

* 📊 **Spam Reporting System**

  * Users can report phone numbers and messages as spam.

* 📈 **Spam Score Tracking**

  * Stores and retrieves spam scores from MongoDB.

* 🌐 **Frontend Interface**

  * Simple UI for reporting and checking spam.

* ⚙️ **Microservice Architecture**

  * Spring Boot communicates with Python service via REST API.

---

## 🧠 System Architecture

```
Frontend → Spring Boot → Python ML Service → MongoDB
```

* **Spring Boot**: Main backend (API gateway, business logic)
* **Python (FastAPI)**: ML prediction service
* **MongoDB**: Data storage
* **Frontend (HTML + JS)**: User interface

---

## 📦 Tech Stack

* **Backend**: Spring Boot (Java)
* **ML Service**: Python (FastAPI)
* **Database**: MongoDB
* **Frontend**: HTML, CSS, JavaScript
* **Communication**: REST APIs

---

## 🔗 API Endpoints

### 1. Predict Spam

```
POST /prediction
```

**Request:**

```json
{
  "message": "You won 500000 rupees"
}
```

**Response:**

```json
{
  "label": "Spam",
  "prediction": 0.88
}
```

---

### 2. Report Spam

```
POST /SpamReport
```

**Request:**

```json
{
  "phoneNumber": "9876543210",
  "message": "Spam message"
}
```

---

### 3. Check Spam Score

```
POST /CheckScore?phoneNumber=9876543210
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone <your-repo-url>
cd <project-folder>
```

---

### 2. Run MongoDB

Make sure MongoDB is running on:

```
mongodb://localhost:27017
```

---

### 3. Run Python ML Service

Navigate to Python project:

```bash
cd python-service
uvicorn main:app --reload --port 8000
```

---

### 4. Run Spring Boot Backend

```bash
cd spring-backend
mvn spring-boot:run
```

---

### 5. Open Frontend

Open `index.html` in browser.

---

## 🧪 Testing

* Use browser UI or `curl` to test endpoints.
* Ensure Python service is running before hitting prediction API.

---

## ⚠️ Notes

* MongoDB Compass may not auto-refresh immediately.
* Backend writes are instant; UI refresh may be required.
* Ensure correct JSON format (use `:` not `=`).

---

## 🚀 Future Improvements

* Add authentication & user tracking
* Implement rate limiting for spam reports
* Dockerize services (Spring + Python + MongoDB)
* Improve frontend UI (React or advanced styling)

---

## 🧑‍💻 Author

Developed as a full-stack + ML integration project to demonstrate:

* Microservice communication
* REST API design
* Backend + ML pipeline integration

---

## 📌 Status

✔ Functional
✔ End-to-end pipeline working
🚧 Improvements ongoing

---
