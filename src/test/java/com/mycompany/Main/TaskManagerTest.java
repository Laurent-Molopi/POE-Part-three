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
public class TaskManagerTest {
    @Test
    public void testAddTask() {
        TaskManager manager = new TaskManager();
        Task task = new Task();
        task.setTaskDetails("Login", "Create Login", "Mike Smith", 5, "To Do", 0);
        manager.addTask(task);
        assertEquals(1, manager.getTaskNames().size());
        assertEquals("Mike Smith", manager.getDevelopers().get(0));

    }

    @Test
    public void testDisplayCompletedTasks() {
        TaskManager manager = new TaskManager();
        Task task = new Task();
        task.setTaskDetails("Report", "Generate Report", "John Doe", 3, "Done", 0);
        manager.addTask(task);
        String result = manager.displayCompletedTasks();
        assertTrue(result.contains("Report"));
    }

    @Test
    public void testDeleteTaskByName() {
        TaskManager manager = new TaskManager();
        Task task = new Task();
        task.setTaskDetails("Login", "Create Login", "Mike Smith", 5, "To Do", 0);
        manager.addTask(task);
        String result = manager.deleteTaskByName("Login");
        assertEquals("Task 'Login' deleted successfully.", result);
        assertEquals(0, manager.getTaskNames().size());
    }
}
