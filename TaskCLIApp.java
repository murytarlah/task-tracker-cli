public class TaskCLIApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        /**
         * Check if the user has provided the command
         */
        if (args.length < 1) {
            System.out.println("Usage: TaskCLIApp <command> [arguments]");
            System.out.println("Commands:");
            System.out.println("  \t add <description> - Add a new task");
            System.out.println("  \t update <id> <description> - Update the description of a task");
            System.out.println("  \t list - List all tasks");
            System.out.println("  \t mark-in-progress <id> - Mark a task as in progress");
            System.out.println("  \t mark-done <id> - Mark a task as done");
            System.out.println("  \t delete <id> - Delete a task");
            return;
        }

        // Get the command
        String command = args[0];

        /**
         * Check the command and call the appropriate method
         */
        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLIApp add <description>");
                    return;
                }
                taskManager.addTask(args[1]);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: TaskCLIApp update <id> <new description>");
                    return;
                }
                taskManager.updateTask(args[1], args[2]);
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLIApp delete <id>");
                    return;
                }
                taskManager.deleteTask(args[1]);
                break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLIApp mark-in-progress <id>");
                    return;
                }
                taskManager.markInProgress(args[1]);
                break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Usage: TaskCLIApp mark-done <id>");
                    return;
                }
                taskManager.markDone(args[1]);
                break;
            case "list":
                if (args.length >= 2) {
                    String option = args[1];

                    switch (option) {
                        case "todo":
                            taskManager.listTasks("todo");
                            break;
                        case "in-progress":
                            taskManager.listTasks("in-progress");
                            break;
                        case "done":
                            taskManager.listTasks("done");
                            break;
                        default:
                            System.out.println("Usage: TaslCLIApp list <option>");
                            break;
                    }
                }
                taskManager.listTasks(null);
                break;
            default:
                System.out.println("Usage: TaskCLIApp <command> [arguments]");

        }
        taskManager.saveTasks();
    }
}