# 🚀 NO BS Spring Boot Guide (v2) — `nobsv2`

This project is part of a hands-on, no-fluff tutorial series on Spring Boot, guided by [Peachez Programming](https://www.youtube.com/@peachezprogramming). It's a **work-in-progress** backend project using Spring Boot 3+ and MariaDB as the database.

---

## 📦 Tech Stack

- ☕ Java (JDK 17)
- ⚙️ Spring Boot
- 🐬 MariaDB (local)
- 🐧 Fedora Linux
- 🛠️ Maven

---

## ⚙️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/RanXom/nobsv2.git
cd nobsv2
```

### 2. Set up the database

Create a local MariaDB database named `nobsv2`:

```sql
CREATE DATABASE nobsv2;
```

You can use a DB client like `DBeaver`, `HeidiSQL`, or terminal access via:
```bash
mysql -u root -p
```

### 3. Configure `application.properties`

Create a file:  
`src/main/resources/application.properties`

Example content:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/nobsv2
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
```

---

## 🏃 Running the Project
> ***Use IntelliJ IDEA (Recommended).***

or Run using Spring Boot CLI :

```bash
./mvnw spring-boot:run
```

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/nobsv2/
│   └── resources/
│       └── application.properties (ignored)
```

---

## 🔐 Security & Credentials

Sensitive config like database credentials are not committed to this repo.

---

## 📌 Status

> 🧪 This is a **tutorial WIP** project. It may not be production-ready. The goal is to learn Spring Boot fundamentals through building.

---

## 📜 License

This is a learning-focused project. Use it freely with credit.

---

## 🙌 Acknowledgements

- [Peachez Programming's No BS Guide to Spring Boot (v2)](https://www.youtube.com/playlist?list=PL7TZZ2ip0DRCmJ57pzkc3EChRTJ6pm_bH)