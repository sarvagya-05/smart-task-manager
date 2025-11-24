package taskmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    public void loadTasks(List<Task> loadedTasks) {
        if (loadedTasks == null) {
            return;
        }
        this.tasks.clear();
        this.tasks.addAll(loadedTasks);

        int maxId = 0;
        for (Task t : tasks) {
            if (t.getId() > maxId) {
                maxId = t.getId();
            }
        }
        this.nextId = maxId + 1;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task addTask(String title, String description, String dueDate, Task.Priority priority) {
        Task task = new Task(nextId++, title, description, dueDate, priority, false);
        tasks.add(task);
        return task;
    }

    public boolean markCompleted(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setCompleted(true);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public List<Task> getTasksSortedByPriorityAndDeadline() {
        List<Task> sorted = new ArrayList<>(tasks);
        Collections.sort(sorted, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                // higher priority first
                int pCompare = t2.getPriority().ordinal() - t1.getPriority().ordinal();
                if (pCompare != 0) {
                    return pCompare;
                }
                // if same priority, earlier due date first
                return t1.getDueDate().compareTo(t2.getDueDate());
            }
        });
        return sorted;
    }
}
