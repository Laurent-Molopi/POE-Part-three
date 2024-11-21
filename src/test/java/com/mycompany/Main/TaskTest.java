/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.Main;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author south
 */
public class TaskTest {
    @Test
    public void testCheckTaskDescription() {
        Task task = new Task();
        assertTrue(task.checkTaskDescription("This is a valid task description."));
        assertFalse(task.checkTaskDescription("This task description is far too long and exceeds the fifty-character limit."));
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task();
        String taskID = task.createTaskID("Login Feature", 0, "Robyn Harrison");
        assertEquals("LO:0:SON", taskID);
    }

    @Test
    public void testPrintTaskDetails() {
        Task task = new Task();
        task.setTaskDetails("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do", 0);
        String details = task.printTaskDetails();
        assertTrue(details.contains("Task Status: To Do"));
        assertTrue(details.contains("Developer Details: Robyn Harrison"));
        assertTrue(details.contains("Task Name: Login Feature"));
        assertTrue(details.contains("Duration: 8 hours"));
    }
}
