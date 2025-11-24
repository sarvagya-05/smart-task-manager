Smart Task Manager with Priority Sorting

Project for: VITyarthi – Java Programming
Student Name: YOUR NAME
Registration Number: YOUR REGISTRATION NUMBER
Project Title: Smart Task Manager with Priority Sorting

1. Overview

Managing tasks becomes challenging when deadlines, priorities, and descriptions are scattered across notes, reminders, or memory. Without a structured approach, important tasks are often delayed or forgotten.

This project presents a console-based Smart Task Manager written in Core Java, which allows users to add tasks, define deadlines, assign priorities, and organize their work efficiently.

The program stores tasks permanently using file handling and automatically sorts them so that the most important tasks appear at the top. This demonstrates practical usage of Java concepts such as classes, objects, ArrayLists, sorting with comparators, and file I/O.

2. Objectives

The key objectives of this project are:

To develop a modular Java application using Object-Oriented Programming principles.

To organize user tasks by taking inputs such as title, description, due date, and priority.

To apply Java's sorting mechanisms for arranging tasks based on urgency.

To use file handling for permanent storage of tasks.

To design a simple, menu-driven system that is user-friendly.

To demonstrate practical implementation of course concepts in a real application.

3. Problem Statement

When users manage multiple activities simultaneously, it becomes difficult to track deadlines and prioritize tasks manually. Traditional notes or reminders are not systematic and lack automatic organization.

There is a need for a lightweight task manager that:

Collects tasks in a structured manner

Sorts tasks based on priority and deadlines

Provides progress tracking

Saves data permanently

Offers simple interaction through a console menu

This project fulfills these needs by implementing a Smart Task Manager in Java.

4. Working of the Project

The project follows a menu-driven structure. When executed, the program first loads previously saved tasks from the tasks.txt file. It then displays the following menu:

1. Add Task
2. View Tasks (sorted by priority & deadline)
3. Mark Task as Completed
4. Delete Task
5. Save & Exit

How Sorting Works

Tasks are sorted according to:

Priority (HIGH → MEDIUM → LOW)

Due date (earlier dates come first)

Data Persistence

All tasks are saved in a text file using a custom-storable format. When the program is launched again, this file is read and tasks are reconstructed.

Main Operations

Add new tasks

View tasks in sorted order

Mark tasks as completed

Remove tasks

Save tasks permanently

5. Features

Add tasks with title, description, due date, and priority

Tasks automatically sorted by urgency

Mark completion status

Delete tasks

Permanent storage using text file

Unique IDs for each task

Clean modular code structure using multiple classes

Uses Java Collections Framework

6. Project Structure
smart-task-manager/
│
├─ src/
│  └─ taskmanager/
│     ├─ Main.java
│     ├─ Task.java
│     ├─ TaskManager.java
│     └─ TaskStorage.java
│
├─ data/
│  └─ tasks.txt
│
├─ screenshots/
├─ recordings/
├─ README.md
└─ .gitignore

7. Technologies and Concepts Used

Core Java

Object-Oriented Programming

ArrayList and Collection Framework

Comparator for custom sorting

File Handling (BufferedReader, BufferedWriter)

Scanner for user input

Modular design

8. How to Run
Step 1: Compile
javac -d bin src/taskmanager/*.java

Step 2: Execute
java -cp bin taskmanager.Main

9. Sample Output
==== SMART TASK MANAGER ====
1. Add Task
2. View Tasks (sorted by priority & deadline)
3. Mark Task as Completed
4. Delete Task
5. Save & Exit
Enter choice:


Example task display:

[ID: 2] Finish Java Project (Priority: HIGH, Due: 2025-11-26, Status: PENDING)
    Complete the Smart Task Manager implementation.

10. Screenshots

Screenshots demonstrating the working of the project are available in the screenshots/ folder:

Main menu

Adding a task

Viewing sorted tasks

Marking a task completed

Deleting a task

Saved tasks.txt file

11. Student and Submission Details

Project: Smart Task Manager with Priority Sorting

Student Name: Your Name

Registration Number: Your Registration Number

University: VIT Bhopal University

Course: Java Programming

Submitted Through: VITyarthi

Faculty: Optional

12. Conclusion

The Smart Task Manager demonstrates how object-oriented programming and Java’s collection framework can be applied to solve a real-world organizational problem. By implementing sorting, encapsulation, modular design, and file storage, the project provides a functional, easy-to-use system for managing tasks.

The program fulfills all defined objectives and can be enhanced further by adding features such as reminders, color coding, or a graphical user interface.