package com.edsoft.ToDoList.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskModelTest {

    @Test
    public void testTaskId() {
        Task task = new Task();
        task.setId("task123");
        assertEquals("task123", task.getId());
    }

    @Test
    public void testTitle() {
        Task task = new Task();
        task.setTitle("Task Title");
        assertEquals("Task Title", task.getTitle());
    }

    @Test
    public void testDescription() {
        Task task = new Task();
        task.setDescription("Task Description");
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testStatus() {
        Task task = new Task();
        assertEquals(Status.NoProgress, task.getStatus());
    }

    @Test
    public void testUserId() {
        Task task = new Task();
        task.setUserId("user123");
        assertEquals("user123", task.getUserId());
    }
}
