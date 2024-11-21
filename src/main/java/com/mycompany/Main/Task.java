/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main;
/**
 *
 * @author south
 */
public class Task {
    // Private variables to store task details
    private String taskName;          // Name of the task
    private int taskNumber;           // Unique number for the task
    private String taskDescription;   // Description of the task (max 50 characters)
    private String developerDetails;  // Developer assigned to the task
    private int taskDuration;         // Estimated duration of the task in hours
    private String taskID;            // Unique ID for the task
    private String taskStatus;        // Status of the task (e.g., To Do, Doing, Done)

    // Method to check if the task description is valid
    public boolean checkTaskDescription(String description) {
        // Ensures the description is 50 characters or fewer
        return description.length() <= 50;
    }

    // Method to create a unique Task ID
    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        // Task ID format: First two letters of task name, task number, and last three letters of developer name
        String taskNamePart = taskName.substring(0, 2).toUpperCase(); // First 2 letters of task name in uppercase
        String developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase(); // Last 3 letters of developer name in uppercase
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }

    // Method to set all the details of a task
    public void setTaskDetails(String taskName, String taskDescription, String developerDetails,
                                int taskDuration, String taskStatus, int taskNumber) {
        // Assign values to the private variables
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskNumber;
        // Generate and assign the task ID using the provided details
        this.taskID = createTaskID(taskName, taskNumber, developerDetails);
    }

    // Method to print all the details of a task
    public String printTaskDetails() {
        // Formats and returns the task details as a string
        return "Task Status: " + taskStatus +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription +
               "\nTask ID: " + taskID +
               "\nDuration: " + taskDuration + " hours";
    }

    // Getter method for task duration
    public int getTaskDuration() {
        return taskDuration;
    }

    // Getter method for task status
    public String getTaskStatus() {
        return taskStatus;
    }

    // Getter method for task name
    public String getTaskName() {
        return taskName;
    }

    // Getter method for developer details
    public String getDeveloperDetails() {
        return developerDetails;
    }
}
