import java.time.LocalDateTime;

public class Task {
    private static int lastId = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void markInProgress() {
        this.status = Status.IN_PROGRESS;
        this.updatedAt = LocalDateTime.now();
    }

    public void markDone() {
        this.status = Status.DONE;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateTask(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public String toJson() {
        return "\n\t{\t\"id\":" + id + ",\n\t\t\"description\":\"" + description + "\",\n\t\t\"status\":\"" + status
                + "\",\n\t\t\"createdAt\":\""
                + createdAt + "\",\n\t\t\"updatedAt\":\"" + updatedAt + "\"\n\t}";
    }

    public static Task fromJson(String json) {
        json = json.replace("{", "").replace("}", "").replace("\"", "");
        String[] parts = json.split(",");
        String description = parts[1].split(":")[1];
        Task task = new Task(description);
        task.id = Integer.parseInt(parts[0].split(":")[1]);
        task.status = Status.valueOf(parts[2].split(":")[1].replace(" ", "_").toUpperCase());
        task.createdAt = LocalDateTime.parse(parts[3].split("[a-z]:")[1].strip().replace("\"", ""));
        task.updatedAt = LocalDateTime.parse(parts[4].split("[a-z]:")[1].strip().replace("\"", ""));
        return task;
    }

    public String toString() {
        return "Id: " + id + "\nDescription: " + description + "\nStatus: " + status + "\nCreated at: " + createdAt
                + "\nUpdated at: " + updatedAt;
    }

}
