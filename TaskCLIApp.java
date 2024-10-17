public class TaskCLIApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        /**
         * Check if the user has provided the command
         */
        if (args.length < 1) {
            System.out.println("Usage: TaskCLIApp <command> [arguments]");
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

            case "list":
                taskManager.listTasks(null);
                break;
            default:
                System.out.println("Usage: TaskCLIApp <command> [arguments]");
                System.out.println("Commands:");
                System.out.println("  \t add <description> - Add a new task");
                System.out.println("  \t update <id> <description> - Update the description of a task");
                System.out.println("  \t list - List all tasks");
                System.out.println("  \t mark-in-progress <id> - Mark a task as in progress");
                System.out.println("  \t mark-done <id> - Mark a task as done");
                System.out.println("  \t delete <id> - Delete a task");

        }
        taskManager.saveTasks();
    }
}