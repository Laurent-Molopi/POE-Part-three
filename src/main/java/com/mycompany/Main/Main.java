/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Main;
import javax.swing.JOptionPane;
/**
 *
 * @author south
 */
public class Main {
    public static void main(String[] args) {
        // Create objects for login and task manager
        Login login = new Login();
        TaskManager taskManager = new TaskManager();

        // User Registration
        boolean validRegistration = false;
        while (!validRegistration) {
            // Ask the user for their first name
            String firstName = JOptionPane.showInputDialog("Enter your first name:");
            if (firstName == null) exitProgram(); // Exit if the user cancels

            // Ask the user for their last name
            String lastName = JOptionPane.showInputDialog("Enter your last name:");
            if (lastName == null) exitProgram();

            // Ask the user for their username
            String username = JOptionPane.showInputDialog("Enter your username:");
            if (username == null) exitProgram();

            // Ask the user for their password
            String password = JOptionPane.showInputDialog("Enter your password:");
            if (password == null) exitProgram();

            // Register the user and display the result
            String registrationMessage = login.registerUser(username, password, firstName, lastName);
            JOptionPane.showMessageDialog(null, registrationMessage);

            // If registration is successful, break out of the loop
            if (registrationMessage.contains("successfully")) {
                validRegistration = true;
            }
        }

        // User Login
        boolean loggedIn = false;
        while (!loggedIn) {
            // Ask the user for their username
            String username = JOptionPane.showInputDialog("Enter your username to log in:");
            if (username == null) exitProgram();

            // Ask the user for their password
            String password = JOptionPane.showInputDialog("Enter your password to log in:");
            if (password == null) exitProgram();

            // Check the login status and display the result
            String loginMessage = login.returnLoginStatus(username, password);
            JOptionPane.showMessageDialog(null, loginMessage);

            // If login is successful, break out of the loop
            if (login.loginUser(username, password)) {
                loggedIn = true;
            }
        }

        // Main Menu (after login)
        boolean exit = false;
        while (!exit) {
            // Show the main menu
            String mainMenu = """
                    === Main Menu ===
                    1. Add Task
                    2. Show Report
                    3. Quit
                    """;

            // Ask the user to choose an option
            String mainChoice = JOptionPane.showInputDialog(mainMenu + "\nEnter your choice:");
            if (mainChoice == null) exitProgram(); // Exit if the user cancels

            switch (mainChoice) {
                case "1":
                    // Go to Add Task
                    addTask(taskManager);
                    break;

                case "2":
                    // Go to Show Report Menu
                    showReportMenu(taskManager);
                    break;

                case "3":
                    // Quit the program
                    exit = true;
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;

                default:
                    // If the input is invalid, show an error
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    // Add Task method
    private static void addTask(TaskManager taskManager) {
        // Ask the user how many tasks they want to add
        String taskCountInput = JOptionPane.showInputDialog("How many tasks would you like to add?");
        if (taskCountInput == null) return; // Exit if the user cancels

        int taskCount = 0;
        try {
            // Convert the input to a number
            taskCount = Integer.parseInt(taskCountInput);
            if (taskCount <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            // If the input is invalid, show an error and return
            JOptionPane.showMessageDialog(null, "Invalid number. Please try again.");
            return;
        }

        // Loop to add multiple tasks
        for (int i = 0; i < taskCount; i++) {
            boolean validTask = false;
            while (!validTask) {
                // Ask for task details
                String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                if (taskName == null) break;

                String taskDescription = JOptionPane.showInputDialog("Enter Task Description (Max 50 chars):");
                if (taskDescription == null) break;

                // Check if the description is too long
                if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Description too long! Please enter less than 50 characters.");
                    continue;
                }

                String developerDetails = JOptionPane.showInputDialog("Enter Developer Details:");
                if (developerDetails == null) break;

                // Provide a dropdown to select task status
                String[] statuses = {"To Do", "Doing", "Done"};
                String taskStatus = (String) JOptionPane.showInputDialog(null,
                        "Select Task Status:", "Task Status",
                        JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
                if (taskStatus == null) break;

                String durationInput = JOptionPane.showInputDialog("Enter Task Duration (hours):");
                if (durationInput == null) break;

                int taskDuration;
                try {
                    // Convert the input to a number
                    taskDuration = Integer.parseInt(durationInput);
                    if (taskDuration <= 0) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    // If the input is invalid, show an error and continue
                    JOptionPane.showMessageDialog(null, "Invalid duration. Please try again.");
                    continue;
                }

                // Create a new task and add it to the task manager
                Task task = new Task();
                task.setTaskDetails(taskName, taskDescription, developerDetails, taskDuration, taskStatus, taskManager.getTaskNames().size());
                taskManager.addTask(task);

                // Show success message
                JOptionPane.showMessageDialog(null, "Task successfully captured!");
                validTask = true; // Exit the loop for the current task
            }
        }
    }

    // Show Report Menu method
    private static void showReportMenu(TaskManager taskManager) {
        boolean backToMainMenu = false;
        while (!backToMainMenu) {
            // Show the report menu
            String reportMenu = """
                    === Show Report ===
                    1. Display All Tasks
                    2. Display Completed Tasks
                    3. Display Longest Task
                    4. Search Task by Name
                    5. Search Tasks by Developer
                    6. Delete Task by Name
                    7. Close
                    """;

            // Ask the user to choose an option
            String reportChoice = JOptionPane.showInputDialog(reportMenu + "\nEnter your choice:");
            if (reportChoice == null) return; // Exit if the user cancels

            switch (reportChoice) {
                case "1":
                    // Show all tasks
                    JOptionPane.showMessageDialog(null, taskManager.displayAllTasks());
                    break;

                case "2":
                    // Show completed tasks
                    JOptionPane.showMessageDialog(null, taskManager.displayCompletedTasks());
                    break;

                case "3":
                    // Show the task with the longest duration
                    JOptionPane.showMessageDialog(null, taskManager.displayLongestTask());
                    break;

                case "4":
                    // Search for a task by name
                    String searchName = JOptionPane.showInputDialog("Enter the Task Name to search:");
                    if (searchName != null) {
                        JOptionPane.showMessageDialog(null, taskManager.searchTaskByName(searchName));
                    }
                    break;

                case "5":
                    // Search for tasks by developer
                    String developer = JOptionPane.showInputDialog("Enter the Developer's Name to search tasks:");
                    if (developer != null) {
                        JOptionPane.showMessageDialog(null, taskManager.searchTasksByDeveloper(developer));
                    }
                    break;

                case "6":
                    // Delete a task using a dropdown
                    if (taskManager.getTaskNames().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No tasks available to delete.");
                        break;
                    }

                    String[] taskNamesArray = taskManager.getTaskNames().toArray(new String[0]);
                    String deleteName = (String) JOptionPane.showInputDialog(null,
                            "Select the Task to delete:", "Delete Task",
                            JOptionPane.QUESTION_MESSAGE, null, taskNamesArray, taskNamesArray[0]);

                    if (deleteName != null) {
                        JOptionPane.showMessageDialog(null, taskManager.deleteTaskByName(deleteName));
                    }
                    break;

                case "7":
                    // Return to the main menu
                    backToMainMenu = true;
                    break;

                default:
                    // If the input is invalid, show an error
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    // Exit the program
    private static void exitProgram() {
        JOptionPane.showMessageDialog(null, "Exiting program. Goodbye!");
        System.exit(0);
    }
}
