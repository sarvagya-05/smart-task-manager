## Smart Task Manager with Priority Sorting
**Author:** Sarvagya Shrivastava
**Registration Number:** 24BCE10309

A structured Java SE console application demonstrating core programming concepts including OOP, modular design, collections, comparators, file I/O, and exception handling.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Java Platform Overview](#java-platform-overview)
- [Installation & Setup](#installation--setup)
- [Architecture & Design](#architecture--design)
- [Features](#features)
- [Usage](#usage)
- [Technical Requirements Mapping](#technical-requirements-mapping)
- [Build & Run](#build--run)
- [Acknowledgments](#acknowledgments)

---

## Project Overview

The **Smart Task Manager** is a console-based Java SE application designed to help users organize and manage tasks efficiently. It allows users to:

- Create tasks with title, description, due date, and priority
- Sort tasks automatically based on priority and deadline
- Mark tasks as completed
- Delete tasks using unique task IDs
- Load and save tasks using a simple text file

This project demonstrates how core Java fundamental concepts can be combined to build a functional system with real-world utility.

### Key Features

- Complete OOP-based design
- Layered architecture (model, logic, storage, UI)
- Comparator-based sorting
- Persistent task storage via file I/O
- Robust input handling and basic validations
- Clean, menu-driven user interface

---

## Java Platform Overview

### Evolution of Java (Concise)

- 1995: Java 1.0
- 1998: Java 1.2 – Collections Framework
- 2004: Java 5 – Enums, Generics, Annotations
- 2014: Java 8 – Lambdas, Streams, Date/Time API
- 2017–2023: Continued evolution with modules, text blocks, pattern matching

### Java Editions

| Edition | Description | Use Cases | Key Features |
|---------|-------------|-----------|--------------|
| **Java SE** | Standard Edition | Desktop apps, CLI tools | Core libraries, JVM |
| **Java EE** | Enterprise Edition | Web apps, enterprise systems | Servlets, JPA, EJB |
| **Java ME** | Micro Edition | Embedded devices | Lightweight APIs |

### Java Architecture

```

┌───────────────────────────────────────────┐

│               JDK (Development Kit)        │

│   ┌─────────────────────────────────────┐  │

│   │        JRE (Runtime Environment)     │  │

│   │   ┌───────────────────────────────┐ │  │

│   │   │        JVM (Virtual Machine)  │ │  │

│   │   │  - Executes bytecode          │ │  │

│   │   │  - Memory management          │ │  │

│   │   └───────────────────────────────┘ │  │

│   └─────────────────────────────────────┘  │

└───────────────────────────────────────────┘

```

Flow:
`.java` → `javac` → `.class` → JVM → execution

---

## Installation & Setup

### Requirements

- JDK 8 or higher
- Windows/macOS/Linux
- Terminal or VS Code

### Folder Structure

```

smart-task-manager/

├── src/

│   └── taskmanager/

│       ├── Main.java

│       ├── Task.java

│       ├── TaskManager.java

│       └── TaskStorage.java

├── data/

│   └── tasks.txt

├── README.md

└── .gitignore

```

---

## Architecture & Design

### Package Structure

```

taskmanager/

├── Main.java            # Main application class

├── Task.java            # Task model

├── TaskManager.java     # Core business logic

└── TaskStorage.java     # File I/O operations

```

### OOP Principles Applied

1. **Encapsulation** – Private fields with controlled access
2. **Abstraction** – Each layer handles a specific responsibility
3. **Modularity** – Clear separation of logic, UI, storage, and model
4. **Comparator-based Polymorphism** – Custom sorting logic

### Design Layers

- **Model Layer:** Task.java
- **Logic Layer:** TaskManager.java
- **Persistence Layer:** TaskStorage.java
- **Presentation Layer:** Main.java

---

## Features

### Task Management

- Add new tasks
- View tasks sorted by priority and due date
- Mark tasks as completed
- Delete tasks
- Assign unique task IDs

### Sorting Mechanism

- Priority order: **HIGH → MEDIUM → LOW**
- Earlier due dates appear first within the same priority

### File Storage

- Tasks are saved to `data/tasks.txt`
- Tasks automatically load on program startup

### CLI Interface

- Clean, text-based menu
- Simple keyboard-driven operations

---

## Usage

### Running the Application

After compilation, run:

```bash

java -cp bin taskmanager.Main

```

The main menu includes:

- Add Task
- View Tasks
- Mark Completed
- Delete Task
- Save & Exit

Each operation is initiated through numeric menu selection.

---

## Technical Requirements Mapping

| Requirement | Implementation | Location |
|------------|----------------|----------|
| Encapsulation | Private task fields | Task.java |
| Abstraction | Separation of UI, logic, storage | All classes |
| Collections | ArrayList for storing tasks | TaskManager.java |
| Comparator Sorting | Custom priority/date sorting | TaskManager.java |
| File Handling | Save/Load tasks | TaskStorage.java |
| Exception Handling | Try/catch for file I/O | TaskStorage.java |
| Enums | Priority levels | Task.java |
| CLI Menu | Console-based interface | Main.java |

---

## Build & Run

### Compilation

```bash

javac -d bin src/taskmanager/\*.java

```

### Execution

```bash

java -cp bin taskmanager.Main

```

---

## Acknowledgments

This project demonstrates how Java SE concepts can be applied to construct a functional, real-world console application. Its modular structure, sorting mechanisms, and persistent storage approach reflect standard Java programming practices.

 Smart Task Manager with Priority Sorting
**Author:** YOUR NAME
**Registration Number:** YOUR REGISTRATION NUMBER

A structured Java SE console application demonstrating core programming concepts including OOP, modular design, collections, comparators, file I/O, and exception handling.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Java Platform Overview](#java-platform-overview)
- [Installation & Setup](#installation--setup)
- [Architecture & Design](#architecture--design)
- [Features](#features)
- [Usage](#usage)
- [Technical Requirements Mapping](#technical-requirements-mapping)
- [Build & Run](#build--run)
- [Acknowledgments](#acknowledgments)

---

## Project Overview

The **Smart Task Manager** is a console-based Java SE application designed to help users organize and manage tasks efficiently. It allows users to:

- Create tasks with title, description, due date, and priority
- Sort tasks automatically based on priority and deadline
- Mark tasks as completed
- Delete tasks using unique task IDs
- Load and save tasks using a simple text file

This project demonstrates how core Java fundamental concepts can be combined to build a functional system with real-world utility.

### Key Features

- Complete OOP-based design
- Layered architecture (model, logic, storage, UI)
- Comparator-based sorting
- Persistent task storage via file I/O
- Robust input handling and basic validations
- Clean, menu-driven user interface

---

## Java Platform Overview

### Evolution of Java (Concise)

- 1995: Java 1.0
- 1998: Java 1.2 – Collections Framework
- 2004: Java 5 – Enums, Generics, Annotations
- 2014: Java 8 – Lambdas, Streams, Date/Time API
- 2017–2023: Continued evolution with modules, text blocks, pattern matching

### Java Editions

| Edition | Description | Use Cases | Key Features |
|---------|-------------|-----------|--------------|
| **Java SE** | Standard Edition | Desktop apps, CLI tools | Core libraries, JVM |
| **Java EE** | Enterprise Edition | Web apps, enterprise systems | Servlets, JPA, EJB |
| **Java ME** | Micro Edition | Embedded devices | Lightweight APIs |

### Java Architecture

```

┌───────────────────────────────────────────┐

│               JDK (Development Kit)        │

│   ┌─────────────────────────────────────┐  │

│   │        JRE (Runtime Environment)     │  │

│   │   ┌───────────────────────────────┐ │  │

│   │   │        JVM (Virtual Machine)  │ │  │

│   │   │  - Executes bytecode          │ │  │

│   │   │  - Memory management          │ │  │

│   │   └───────────────────────────────┘ │  │

│   └─────────────────────────────────────┘  │

└───────────────────────────────────────────┘

```

Flow:
`.java` → `javac` → `.class` → JVM → execution

---

## Installation & Setup

### Requirements

- JDK 8 or higher
- Windows/macOS/Linux
- Terminal or VS Code

### Folder Structure

```

smart-task-manager/

├── src/

│   └── taskmanager/

│       ├── Main.java

│       ├── Task.java

│       ├── TaskManager.java

│       └── TaskStorage.java

├── data/

│   └── tasks.txt

├── README.md

└── .gitignore

```

---

## Architecture & Design

### Package Structure

```

taskmanager/

├── Main.java            # Main application class

├── Task.java            # Task model

├── TaskManager.java     # Core business logic

└── TaskStorage.java     # File I/O operations

```

### OOP Principles Applied

1. **Encapsulation** – Private fields with controlled access
2. **Abstraction** – Each layer handles a specific responsibility
3. **Modularity** – Clear separation of logic, UI, storage, and model
4. **Comparator-based Polymorphism** – Custom sorting logic

### Design Layers

- **Model Layer:** Task.java
- **Logic Layer:** TaskManager.java
- **Persistence Layer:** TaskStorage.java
- **Presentation Layer:** Main.java

---

## Features

### Task Management

- Add new tasks
- View tasks sorted by priority and due date
- Mark tasks as completed
- Delete tasks
- Assign unique task IDs

### Sorting Mechanism

- Priority order: **HIGH → MEDIUM → LOW**
- Earlier due dates appear first within the same priority

### File Storage

- Tasks are saved to `data/tasks.txt`
- Tasks automatically load on program startup

### CLI Interface

- Clean, text-based menu
- Simple keyboard-driven operations

---

## Usage

### Running the Application

After compilation, run:

```bash

java -cp bin taskmanager.Main

```

The main menu includes:

- Add Task
- View Tasks
- Mark Completed
- Delete Task
- Save & Exit

Each operation is initiated through numeric menu selection.

---

## Technical Requirements Mapping

| Requirement | Implementation | Location |
|------------|----------------|----------|
| Encapsulation | Private task fields | Task.java |
| Abstraction | Separation of UI, logic, storage | All classes |
| Collections | ArrayList for storing tasks | TaskManager.java |
| Comparator Sorting | Custom priority/date sorting | TaskManager.java |
| File Handling | Save/Load tasks | TaskStorage.java |
| Exception Handling | Try/catch for file I/O | TaskStorage.java |
| Enums | Priority levels | Task.java |
| CLI Menu | Console-based interface | Main.java |

---

## Build & Run

### Compilation

```bash

javac -d bin src/taskmanager/\*.java

```

### Execution

```bash

java -cp bin taskmanager.Main

```

---

## Acknowledgments

This project demonstrates how Java SE concepts can be applied to construct a functional, real-world console application. Its modular structure, sorting mechanisms, and persistent storage approach reflect standard Java programming practices.
