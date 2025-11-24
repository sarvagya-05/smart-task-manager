# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Commands and development workflow

This is a simple Core Java console application without a build tool (no Maven/Gradle). Use `javac` and `java` directly from the project root.

### Compile

```bash
javac -d bin src/taskmanager/*.java
```

- Compiles all Java sources under `src/taskmanager` into the `bin` directory.
- Run this after changing any `.java` files.

### Run the application

Make sure you run from the project root so the relative `data/tasks.txt` path resolves correctly.

```bash
java -cp bin taskmanager.Main
```

### Data file location

- Tasks are persisted in a plain text file at `data/tasks.txt` relative to the project root.
- If the file does not exist on startup, the app prints "No existing data found. Starting fresh." and creates it on save.

### Linting and testing

- There are no linting tools or automated tests configured in this repository (no `pom.xml`, `build.gradle`, or test sources).
- There is no standard command to "run a single test" or a test suite; adding tests would require introducing a test framework (e.g., JUnit) and corresponding build tooling.

## High-level architecture

### Overview

The app is a small, modular console-based task manager. It follows a simple separation of concerns:

- **User interface and control flow**: `Main`
- **Domain model**: `Task` (plus embedded `Priority` enum)
- **Domain logic / task operations**: `TaskManager`
- **Persistence**: `TaskStorage`

All Java sources live under `src/taskmanager/`. Task data is stored in `data/tasks.txt`.

### Control flow (`Main`)

File: `src/taskmanager/Main.java`

- Defines the entry point `public static void main(String[] args)`.
- Uses a `Scanner` on `System.in` to drive a menu loop:
  - `1. Add Task`
  - `2. View Tasks (sorted by priority & deadline)`
  - `3. Mark Task as Completed`
  - `4. Delete Task`
  - `5. Save & Exit`
- On startup:
  - Calls `TaskStorage.loadFromFile("data/tasks.txt")` to read any previously saved tasks.
  - Passes the resulting list into `TaskManager.loadTasks(...)` so IDs can be continued from the max existing ID.
- For each menu action, `Main` delegates to helper methods that:
  - Collect input from the user (title, description, due date, priority, or task ID).
  - Call the corresponding `TaskManager` method (`addTask`, `getTasksSortedByPriorityAndDeadline`, `markCompleted`, `deleteTask`).
- On "Save & Exit" (`choice == 5`):
  - Calls `TaskStorage.saveToFile("data/tasks.txt", manager.getTasks())`.
  - Exits the loop and closes the `Scanner`.

`Main` does not hold task data itself; it orchestrates between console I/O, `TaskManager`, and `TaskStorage`.

### Domain model (`Task`)

File: `src/taskmanager/Task.java`

- Represents a single task with:
  - `id` (int, unique within the file)
  - `title`, `description`
  - `dueDate` as a `String` in `YYYY-MM-DD` format
  - `priority` as a `Priority` enum (`LOW`, `MEDIUM`, `HIGH`)
  - `completed` (boolean)
- `toString()` formats a human-readable, multi-line representation of a task used by the console UI.
- `toStorageString()` and `fromStorageString(...)` define the on-disk serialization format:
  - One line per task: `id|title|description|dueDate|PRIORITY|completed`
  - `fromStorageString` is tolerant to malformed lines (returns `null` if the split does not yield exactly 6 parts).

### Task management logic (`TaskManager`)

File: `src/taskmanager/TaskManager.java`

- Holds the in-memory list of tasks (`List<Task> tasks`) and the next ID counter (`nextId`).
- `loadTasks(List<Task> loadedTasks)`:
  - Replaces current tasks with `loadedTasks`.
  - Scans for the maximum existing ID and sets `nextId` to `maxId + 1` so new tasks continue the sequence.
- `addTask(...)`:
  - Creates a new `Task` with the next ID and adds it to `tasks`.
- `markCompleted(int id)`:
  - Iterates tasks, sets `completed=true` for the matching ID, and returns `true` if found.
- `deleteTask(int id)`:
  - Uses `removeIf` to drop the task with the given ID.
- `getTasksSortedByPriorityAndDeadline()`:
  - Returns a **new** `List<Task>` sorted using a comparator:
    - Higher `Priority` enum ordinal first (`HIGH` > `MEDIUM` > `LOW`).
    - For equal priority, compares `dueDate` strings lexicographically, which works with the `YYYY-MM-DD` format.

This class centralizes domain rules (ID management, completion, deletion, and sorting), keeping persistence and UI layers thin.

### Persistence layer (`TaskStorage`)

File: `src/taskmanager/TaskStorage.java`

- Package-private utility class responsible for file I/O against `data/tasks.txt`.
- `loadFromFile(String filePath)`:
  - Uses `BufferedReader` to read each line.
  - Converts each line into a `Task` via `Task.fromStorageString` and collects non-null tasks.
  - Catches `IOException` and prints a user-friendly message if the data file does not exist or cannot be read.
- `saveToFile(String filePath, List<Task> tasks)`:
  - Uses `BufferedWriter` to overwrite the file with the current tasks.
  - Writes each task via `Task.toStorageString()` followed by a newline.

`TaskStorage` is only used by `Main`; the rest of the app works purely with in-memory `Task` objects and the `TaskManager` API.
