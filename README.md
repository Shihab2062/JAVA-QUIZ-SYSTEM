🎓 Java quiz System

Project Topic: Java Console-Based Role System
This project is a robust, file-based Quiz Management System developed in Java. It utilizes Object-Oriented Programming (OOP) principles and JSON for data persistence, allowing for a seamless transition between admin management and student evaluation.

📺 Video Demonstration
1. For Admin portal: https://drive.google.com/file/d/14LVu3zWBB06iKHiBR59MjF1kEFxN1dKh/view?usp=sharing

2. For Student portal: https://drive.google.com/file/d/1LDi8Gnk31-eQ-OIAZhOffVF2_2fx4iGN/view?usp=sharing

⚙️ Functional Modules
1. Security & Authentication
The system implements a simple but effective login gate. It parses users.json to validate credentials and identifies the user role (admin or student) to direct the program flow.

2. Admin Module (Question Management)
Persistence: Admins can add Multiple Choice Questions (MCQs) which are instantly appended to quiz.json.

Validation: Each question requires four options and an integer answer key (1-4).

Infinite Loop: Admins can add questions continuously until they trigger the quit command ('q').

3. Student Module (The Quiz)
Randomization: The system uses Collections.shuffle() to pull 10 random questions from the bank, ensuring no two quiz sessions are identical.

Scoring Engine: A real-time counter tracks correct answers with no negative marking.

Performance Feedback: | Score Range | Performance Label | | :--- | :--- | | 8 - 10 | Excellent | | 5 - 7 | Good | | 3 - 4 | Very Poor | | 0 - 2 | Failed |

🏗️ Technical Architecture (OOP)
The project is built using a clean separation of concerns:

Encapsulation: Question data is stored in private/protected fields with specific methods for JSON conversion.

Collection Framework: Uses JSONArrays and ArrayLists to manage and shuffle question sets.

File I/O: Implements FileReader and FileWriter with json-simple to ensure data persists even after the program closes.

🚀 How to Setup
Clone the Repository:

Bash
git clone https://github.com/your-username/quiz-system-batch17.git
Add Dependencies: Ensure the json-simple-1.1.1.jar is added to your project's Build Path/Library.

Run: Execute the QuizSystem.java file.