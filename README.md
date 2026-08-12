🚀 Road to Doomsday

🌐 Live Demo
👉 Road to Doomsday — Live Website
  link -  https://road-to-doomsday.onrender.com/
Track your journey through the Marvel Cinematic Universe...

🎬 About the Project
...

**Road to Doomsday** is a full-stack Marvel Cinematic Universe (MCU) movie tracker designed to help users follow the MCU movie timeline from Phase 1 onward.

The application provides a phase-wise movie timeline with release dates, descriptions, importance levels, poster/trailer support, and watched/unwatched tracking. It also includes a REST API for managing movie data and uses MySQL for persistent storage.

---

## 🎬 Features

- 📽️ MCU movie timeline
- 🗂️ Movies organized by MCU Phase
- 📅 Movie release dates
- 📝 Movie descriptions
- ⭐ Movie importance levels
  - Essential
  - Important
  - Optional
- 👀 Watched / Unwatched movie tracking
- 🖼️ Poster URL support
- 🎞️ Trailer URL support
- ➕ Add new movies
- ✏️ Update existing movies
- 🔍 Retrieve movie information through REST APIs
- 💾 Persistent MySQL database
- 🌐 Web-based frontend
- 🐳 Dockerized application
- ☁️ Cloud deployment
- 🔐 Environment-variable based database configuration

---

## 🛠️ Tech Stack

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven

### Database

- MySQL
- Aiven MySQL

### Frontend

- HTML5
- CSS3
- JavaScript

### DevOps & Deployment

- Docker
- Git
- GitHub
- Render

---

## 🏗️ Project Architecture

```text
                    ┌─────────────────────┐
                    │      Frontend       │
                    │  HTML / CSS / JS    │
                    └──────────┬──────────┘
                               │
                               │ HTTP Requests
                               ▼
                    ┌─────────────────────┐
                    │    Spring Boot     │
                    │      REST API      │
                    └──────────┬──────────┘
                               │
                         Spring Data JPA
                               │
                               ▼
                    ┌─────────────────────┐
                    │       MySQL         │
                    │      Database       │
                    └─────────────────────┘



Deployment Architecture-

GitHub
   │
   ▼
Render
   │
   ├── Docker
   ├── Spring Boot
   └── REST API
          │
          ▼
      Aiven MySQL


📂 Project Structure
road-to-doomsday/
│
├── .mvn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── doomsday/
│   │   │           └── roadtodoomsday/
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   └── MovieController.java
│   │   │               │
│   │   │               ├── model/
│   │   │               │   └── Movie.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── MovieRepository.java
│   │   │               │
│   │   │               └── service/
│   │   │                   └── DataLoader.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   ├── style.css
│   │       │   └── app.js
│   │       │
│   │       └── application.properties
│   │
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .gitignore
└── README.md
