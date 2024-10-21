## TaskCLIApp: A Command-Line Task Manager

This project is a simple command-line application for managing tasks. It allows you to add, update, delete, mark tasks as in progress or done, and list all tasks.

### What I learned

While building this project, I gained experience with the following concepts:

* **Java Programming:** I practiced writing Java classes, methods, and using functionalities like file handling, working with lists, and exception handling.
* **Command-Line Arguments:** I learned how to parse command-line arguments and use them to control the program's behavior.
* **Object-Oriented Programming (OOP):**  I designed classes to represent tasks, their status, and methods to manipulate them.

### How it Works

The project consists of three main classes:

* **Task:** This class represents a single task with properties like description, status (To-do, In-progress, Done), creation and update timestamps, and an ID.
* **TaskManager:** This class manages the list of tasks. It provides methods to add, update, delete, mark tasks as in progress or done, and list all tasks or tasks filtered by status.
* **TaskCLIApp:** This is the main class that interacts with the user through the command line. It parses the user-provided commands and arguments and calls the appropriate methods from the TaskManager class.

### Running the Project

**Prerequisites:**

* Java Runtime Environment (JRE) 11 or above installed on your system. You can check by running

    ```shell
        java -version
    ```

in your terminal.

**Steps:**

1. Clone this repository or download the project files.
2. Open a terminal and navigate to the project directory.
3. Compile the Java files using a command like

    ```shell
    javac -d out TaskCLIApp.java` #This will create a class file for each Java class inside the out directory.
    ```

4. Run the application using the command

    ```shell
    java -cp out TaskCLIApp
    ```

**Using the Application:**

* This command adds a new task with the provided description.

    ```shell
    java -cp out TaskCLIApp add <description>
    ```

* This command updates the description of an existing task with the given ID.

    ```shell
    java -cp out TaskCLIApp update <id> <new description>**: 
    ```

* This command deletes a task with the given ID.

    ```shell
    java -cp out TaskCLIApp delete <id>
    ```

* This command marks a task with the given ID as in progress.

    ```shell
    java -cp out TaskCLIApp mark-in-progress <id>
    ```

* This command marks a task with the given ID as done

    ```shell
    java -cp out TaskCLIApp mark-done <id>
    ```

* This command lists all tasks. You can optionally add a status after `list` (e.g., `list todo`) to filter tasks by their status.

    ```shell
    java -cp out TaskCLIApp list [status]
    ```

The application will provide feedback messages based on the commands and arguments you use.

### Possible Upgrades

Here are some ideas for future improvements to this project:

* **Persistence:** Currently, tasks are stored in a local file. Implementing a database connection would allow persisting tasks across application restarts.
* **User Interface:** Building a graphical user interface (GUI) would make the application more user-friendly for those who prefer a visual interface.
* **Priority Levels:** Assigning priority levels to tasks could provide more organization and control over task management.
* **Due Dates:** Setting due dates for tasks would add a time-sensitive element to tasks.

I hope this README provides a clear understanding of the project! Feel free to use and modify this code as you see fit.

Let's Connect!🌟

* [LinkedIn](https://www.linkedin.com/in/murytarlah)
* [X](https://x.com/murytarlah)
