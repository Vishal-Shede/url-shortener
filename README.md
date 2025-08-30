# 🔗 URL Shortener – Java + MySQL

A simple and functional URL Shortener application built from scratch using **Core Java**, **Spring Boot**, and **MySQL**. This project generates unique short links for long URLs and supports redirection using Base62 encoding.

---

## 🚀 Features

- Convert long URLs to short, unique codes
- Base62 encoding (0–9, a–z, A–Z)
- Redirect short URLs to the original long URLs
- MySQL database for persistent storage
- Layered architecture (Controller → Service → Repository)
- JSON-based APIs (POST, GET)
- Easily extendable to include Redis caching, expiration, analytics, etc.

---

## 🛠️ Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **Build Tool**: Maven
- **Tooling**: IntelliJ IDEA, Postman

---

## 📦 Project Structure

```
urlshortener/
│
├── controller/      # REST API endpoints
├── model/           # JPA Entity
├── repository/      # Data access layer
├── service/         # Business logic
├── util/            # Utility for Base62 encoding
└── application.properties
```

---

## 📬 API Endpoints

### 1. Shorten URL  
**POST** `/api/shorten`

**Request Body:**
```json
{
  "longUrl": "https://chat.openai.com/"
}
```

**Response:**
```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

### 2. Redirect to Long URL  
**GET** `/{shortCode}`

Redirects the short code (e.g., `/abc123`) to the original long URL.

---

## 🧪 Testing

Use **Postman** or **cURL** to test API endpoints.

---

## ⚙️ Configuration

Update your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/urlshortener
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
```

Make sure MySQL is running and the `urlshortener` database is created.

---

## 🧱 Future Improvements

- Add Redis caching
- Set expiration for URLs
- Click analytics (date, IP, count)
- User authentication
- Frontend UI (React or plain HTML/CSS)

---

## 👨‍💻 Author

**Vishal Vasant Shede**  
M.Tech | Backend Developer | Java & Spring Boot Enthusiast  
[GitHub](https://github.com/Vishal-Shede) • [LinkedIn](https://linkedin.com/in/vishal-shede-73111517b)

---

## 📄 License

This project is open-sourced for learning and demo purposes.
