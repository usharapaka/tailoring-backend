# STITCHORA – Smart Tailoring Management Platform

## 1 Project Overview

STITCHORA is a backend application developed to support tailoring services through customer management, tailor management, measurements, orders, appointments, and ratings.

The application is built using Java and Spring Boot, with MySQL as the relational database.

## 2 Key Features

- Customer management
- Tailor management and availability status
- Customer measurement management
- Tailoring order management
- Appointment management
- Tailor ratings and reviews
- User registration and login
- REST API endpoints for frontend integration

## 3 Technology Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | Backend application framework |
| Spring Data JPA | Database operations |
| Hibernate | Object-relational mapping |
| MySQL | Relational database |
| Maven | Dependency management and build |
| Git & GitHub | Version control |

## 4 Application Architecture

```text
React Frontend
      |
      v
 REST API Controllers
      |
      v
    Services
      |
      v
  Repositories
      |
      v
      MySQL
```

## 5 Project Structure

```text
tailoring-backend/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/tailoring/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       └── tailoring_platform/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## 6 Getting Started

### Prerequisites

- Java JDK
- Maven
- MySQL Server
- Visual Studio Code or another Java IDE

### 1. Clone the Repository

```bash
git clone https://github.com/usharapaka/tailoring-backend.git
```

### 2. Open the Project

```bash
cd tailoring-backend
```

### 3. Configure the Database

Create the MySQL database:

```sql
CREATE DATABASE tailoring_db;
```

Configure the datasource URL, username, and password in `src/main/resources/application.properties` to match your local MySQL setup.

### 4. Run the Application

On Windows:

```bash
.\mvnw.cmd spring-boot:run
```

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

The backend will run on the configured application port, which is commonly `8080` in a default local setup.

## 6 Related Repository

**Frontend:** https://github.com/usharapaka/tailoring-frontend

## 7 Project Objective

To simplify tailoring service management by providing backend APIs for customers, tailors, measurements, orders, appointments, and ratings.

##  Developer

**Rapaka Usha**  
B.Tech – Electronics and Communication Engineering  
Anurag University

GitHub: https://github.com/usharapaka

