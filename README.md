# 🎓 Java Quiz System

A robust, file-based Quiz Management System developed in Java. It utilizes Object-Oriented Programming (OOP) principles and JSON for data persistence, enabling seamless transitions between admin and student roles.

---

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [File Structure](#file-structure)
- [Demo](#demo)

---

## Overview

**Project:** Java Console-Based Role System  
This system provides role-based access (Admin/Student) with persistent JSON-based data storage for quiz questions and user credentials.

---

## ✨ Features

### 1. Security & Authentication
- Simple yet effective login gate
- Parses `users.json` to validate credentials
- Role-based access control (Admin/Student)
- Secure role identification for proper program flow

### 2. Admin Module (Question Management)
- **Add Questions:** Admins can add Multiple Choice Questions (MCQs) instantly appended to `quiz.json`
- **Validation:** Each question requires four options and an integer answer key (1-4)
- **Continuous Entry:** Add questions in a loop until quit command ('q')

### 3. Student Module (Quiz Taking)
- **Randomization:** Uses `Collections.shuffle()` to pull 10 random questions per session
- **Scoring Engine:** Real-time counter tracks correct answers (no negative marking)
- **Performance Feedback:**
  | Score | Grade |
  |-------|-------|
  | 8-10  | Excellent |
  | 5-7   | Good |
  | 3-4   | Very Poor |
  | 0-2   | Failed |

---

## 🏗️ Architecture (OOP Principles)

- **Encapsulation:** Question data stored in private/protected fields with JSON conversion methods
- **Collection Framework:** Uses JSONArrays and ArrayLists for efficient question management
- **File I/O:** FileReader/FileWriter with json-simple library for persistent data storage

---

## 📋 Prerequisites

- Java JDK 11 or later
- Git (for version control)
- json-simple-1.1.1.jar (included in dependencies)

---

## 🚀 Installation

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/quiz-system.git
cd quiz-system
```

### 2. Build the Project
```bash
.\gradlew clean build
```

### 3. Verify Dependencies
The json-simple JAR should be in your build path automatically via Gradle.

---

## 💻 Usage

### Run the Application
```bash
.\gradlew run
```

Or execute directly:
```bash
java -cp build/classes/java/main QuizSystem
```

### Run Tests
```bash
.\gradlew test
```

---

## 📂 File Structure

```
src/
├── main/
│   ├── java/
│   │   ├── QuizSystem.java       # Main application entry point
│   │   ├── Question.java         # Question model
│   │   └── User.java             # User model
│   └── resources/
│       ├── quiz.json             # Questions database
│       └── users.json            # User credentials
└── test/
    └── java/                     # Test files
```

---

## 📺 Demo Videos

- **Admin Portal:** [Watch Demo](https://drive.google.com/file/d/14LVu3zWBB06iKHiBR59MjF1kEFxN1dKh/view?usp=sharing)
- **Student Portal:** [Watch Demo](https://drive.google.com/file/d/1LDi8Gnk31-eQ-OIAZhOffVF2_2fx4iGN/view?usp=sharing)

---

## 📦 Deployment to GitHub

```bash
git add .
git commit -m "Initial commit: Java Quiz System"
git branch -M main
git remote add origin https://github.com/your-username/quiz-system.git
git push -u origin main
```

---

## 📝 License

This project is open source and available under the MIT License.