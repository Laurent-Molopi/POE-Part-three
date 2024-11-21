/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main;
import java.util.ArrayList;

/**
 *
 * @author south
 */
public class TaskManager {
    // Private lists to store task information
    private ArrayList<String> developers = new ArrayList<>();  // List of developer names
    private ArrayList<String> taskNames = new ArrayList<>();   // List of task names
    private ArrayList<String> taskIDs = new ArrayList<>();     // List of task IDs
    private ArrayList<Integer> taskDurations = new ArrayList<>(); // List of task durations in hours
    private ArrayList<String> taskStatuses = new ArrayList<>();   // List of task statuses (e.g., To Do, Doing, Done)

    // Getter methods for private lists (used to access the lists from other classes)
    public ArrayList<String> getDevelopers() {
        return developers;
    }

    public ArrayList<String> getTaskNames() {
        return taskNames;
    }

    public ArrayList<String> getTaskIDs() {
        return taskIDs;
    }

    public ArrayList<Integer> getTaskDurations() {
        return taskDurations;
    }

    public ArrayList<String> getTaskStatuses() {
        return taskStatuses;
    }

    // Method to add a new task to the lists
    public void addTask(Task task) {
        developers.add(task.getDeveloperDetails());  // Add developer name
        taskNames.add(task.getTaskName());           // Add task name
        // Generate a unique task ID and add it
        taskIDs.add(task.createTaskID(task.getTaskName(), taskNames.size() - 1, task.getDeveloperDetails()));
        taskDurations.add(task.getTaskDuration());   // Add task duration
        taskStatuses.add(task.getTaskStatus());      // Add task status
    }

    // Method to display all tasks that are marked as "Done"
    public String displayCompletedTasks() {
        StringBuilder completedTasks = new StringBuilder("Completed Tasks:\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatuses.get(i))) { // Check if the task status is "Done"
                completedTasks.append("Developer: ").append(developers.get(i))
                              .append(", Task Name: ").append(taskNames.get(i))
                              .append(", Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
        return completedTasks.toString();
    }

    // Method to find and display the task with the longest duration
    public String displayLongestTask() {
        int maxIndex = 0; // Start with the first task as the longest
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i; // Update the index if a longer task is found
            }
        }
        return "Longest Task:\nDeveloper: " + developers.get(maxIndex) +
               ", Task Name: " + taskNames.get(maxIndex) +
               ", Duration: " + taskDurations.get(maxIndex) + " hours";
    }

    // Method to search for a task by its name
    public String searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) { // Check if task name matches
                return "Task Found:\nDeveloper: " + developers.get(i) +
                       ", Task Name: " + taskNames.get(i) +
                       ", Status: " + taskStatuses.get(i);
            }
        }
        return "Task not found.";
    }

    // Method to search for all tasks assigned to a specific developer
    public String searchTasksByDeveloper(String developer) {
        StringBuilder tasksByDeveloper = new StringBuilder("Tasks for Developer: " + developer + "\n");
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developer)) { // Check if developer matches
                tasksByDeveloper.append("Task Name: ").append(taskNames.get(i))
                                .append(", Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        return tasksByDeveloper.length() > 0 ? tasksByDeveloper.toString() : "No tasks found for developer.";
    }

    // Method to delete a task by its name
    public String deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) { // Check if task name matches
                // Remove all details of the task from the lists
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                return "Task '" + taskName + "' deleted successfully.";
            }
        }
        return "Task not found.";
    }

    // Method to display all tasks in the system
    public String displayAllTasks() {
        StringBuilder allTasks = new StringBuilder("All Tasks:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            allTasks.append("Developer: ").append(developers.get(i))        // Display developer name
                    .append(", Task Name: ").append(taskNames.get(i))       // Display task name
                    .append(", Task ID: ").append(taskIDs.get(i))           // Display task ID
                    .append(", Duration: ").append(taskDurations.get(i))    // Display task duration
                    .append(" hours, Status: ").append(taskStatuses.get(i)) // Display task status
                    .append("\n");
        }
        return allTasks.toString();
    }
}
