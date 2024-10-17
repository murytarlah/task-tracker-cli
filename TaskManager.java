import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private final Path FILE_PATH = Path.of("./tasks.json");
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = loadTasks();
    }

    /**
     * Load tasks from the file
     * 
     * @return List of tasks
     */
    public List<Task> loadTasks() {
        List<Task> storedTasks = new ArrayList<>();

        if (!Files.exists(FILE_PATH)) {
            return new ArrayList<>();
        }

        try {
            String JsonContent = Files.readString(FILE_PATH);
            storedTasks = fromJson(JsonContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return storedTasks;
    }

    /**
     * Save tasks to the file
     */
    public void saveTasks() {
        if (!Files.exists(FILE_PATH)) {
            try {
                Files.createFile(FILE_PATH);
                Files.writeString(FILE_PATH, toJson());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.writeString(FILE_PATH, toJson());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Add a new task
     * 
     * @param description
     */
    public void addTask(String description) {
        Task new_task = new Task(description);
        tasks.add(new_task);
        System.out.println("Task added successfully (ID: " + new_task.getId() + ")");
    }

    /**
     * Update the task with the given ID
     * 
     * @param id
     * @param description
     */
    public void updateTask(String id, String description) {
        Task task = findTask(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));
        task.updateTask(description);
    }

    /**
     * Delete a task with the given ID
     * 
     * @param id
     */
    public void deleteTask(String id) {
        tasks.removeIf(t -> t.getId() == Integer.parseInt(id));
    }

    /**
     * List all tasks
     */
    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task.toJson());
        }
    }

    /**
     * List tasks based on the status
     * 
     * @param status
     */
    public void listTasks(String status) {
        if (status == null) {
            listTasks();
        } else {
            for (Task task : tasks) {
                if (task.getStatus().getValue().equals(status)) {
                    System.out.println(task.toJson());
                }
            }
        }
    }

    public String toJson() {
        StringBuilder json = new StringBuilder("[\n");
        for (Task task : tasks) {
            json.append(task.toJson()).append(",");
        }
        if (tasks.size() > 0) {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("\n]");
        return json.toString();
    }

    /**
     * find a task with the given ID
     * 
     * @param id
     * @return Task
     */
    public Optional<Task> findTask(String id) {
        return tasks.stream().filter(t -> t.getId() == Integer.parseInt(id)).findFirst();
    }

    /**
     * Convert JSON to tasks
     * 
     * @param json
     * @return List of tasks
     */
    public List<Task> fromJson(String json) {
        List<Task> tasks = new ArrayList<>();

        String[] parts = json.substring(1, json.length() - 1).split("},");
        for (String part : parts) {
            Task task = Task.fromJson(part + "}");
            tasks.add(task);
        }
        return tasks;
    }
}
