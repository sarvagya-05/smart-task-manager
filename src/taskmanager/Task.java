package taskmanager;

public class Task {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    private int id;
    private String title;
    private String description;
    private String dueDate;       // format: YYYY-MM-DD
    private Priority priority;
    private boolean completed;

    public Task(int id, String title, String description, String dueDate, Priority priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        String status = completed ? "DONE" : "PENDING";
        return String.format(
                "[ID: %d] %s (Priority: %s, Due: %s, Status: %s)%n    %s",
                id, title, priority, dueDate, status, description
        );
    }

    // convert task to one line for file storage
    public String toStorageString() {
        return id + "|" + title + "|" + description + "|" + dueDate + "|" + priority + "|" + completed;
    }

    // create task back from one line of file
    public static Task fromStorageString(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length != 6) {
            return null;
        }
        int id = Integer.parseInt(parts[0]);
        String title = parts[1];
        String description = parts[2];
        String dueDate = parts[3];
        Priority priority = Priority.valueOf(parts[4]);
        boolean completed = Boolean.parseBoolean(parts[5]);
        return new Task(id, title, description, dueDate, priority, completed);
    }
}
