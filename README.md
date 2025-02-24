# Product API - Spring Boot Backend

This is a REST API backend built with **Spring Boot**, **JPA**, and **H2 Database** to manage products, product types, and colors.

## 🚀 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- H2 (In-Memory Database)
- Lombok
- Postman (for API testing)

## 📌 Installation and Running Locally

### 1️⃣ Clone the project
```bash
git clone https://github.com/your-repo/product-api.git
cd product-api

2️⃣ Build and Run the Backend
mvn clean install
mvn spring-boot:run


3️⃣ Open H2 Console (View Database)
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (leave blank)


📜 Environment Variables
Variable	Default Value
SERVER_PORT	8080
SPRING_DATASOURCE_URL	jdbc:h2:mem:testdb