package taskmanager;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String DATA_FILE = "data/tasks.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        List<Task> loaded = TaskStorage.loadFromFile(DATA_FILE);
        manager.loadTasks(loaded);

        int choice;
        do {
            System.out.println("\n==== SMART TASK MANAGER ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks (sorted by priority & deadline)");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Save & Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTaskFlow(scanner, manager);
                    break;
                case 2:
                    viewTasksFlow(manager);
                    break;
                case 3:
                    markCompletedFlow(scanner, manager);
                    break;
                case 4:
                    deleteTaskFlow(scanner, manager);
                    break;
                case 5:
                    TaskStorage.saveToFile(DATA_FILE, manager.getTasks());
                    System.out.println("Tasks saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addTaskFlow(Scanner scanner, TaskManager manager) {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();

        System.out.print("Priority (1=LOW, 2=MEDIUM, 3=HIGH): ");
        int p = scanner.nextInt();
        scanner.nextLine();
        Task.Priority priority;
        if (p == 3) {
            priority = Task.Priority.HIGH;
        } else if (p == 2) {
            priority = Task.Priority.MEDIUM;
        } else {
            priority = Task.Priority.LOW;
        }

        Task t = manager.addTask(title, description, dueDate, priority);
        System.out.println("Task added with ID: " + t.getId());
    }

    private static void viewTasksFlow(TaskManager manager) {
        List<Task> sorted = manager.getTasksSortedByPriorityAndDeadline();
        if (sorted.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\n--- TASK LIST ---");
        for (Task t : sorted) {
            System.out.println(t);
        }
    }

    private static void markCompletedFlow(Scanner scanner, TaskManager manager) {
        System.out.print("Enter Task ID to mark as completed: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean ok = manager.markCompleted(id);
        if (ok) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void deleteTaskFlow(Scanner scanner, TaskManager manager) {
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean ok = manager.deleteTask(id);
        if (ok) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}
