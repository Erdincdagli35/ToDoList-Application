package com.edsoft.ToDoList.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.edsoft.ToDoList.models.Status;
import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.service.TaskService;
import com.edsoft.ToDoList.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {
/*
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void testAddTaskToUser() throws Exception {
        Task task = new Task();
        task.setId("1");
        task.setTitle("Test Task");
        task.setDescription("Description");

        User user = new User();
        user.setUserName("user1");

        when(taskService.addTaskToUser(any(Task.class), eq("user1"))).thenReturn(String.valueOf(task));

        mockMvc.perform(post("/addTaskToUser/user1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.title").value("Test Task"))
                .andExpect(jsonPath("$.description").value("Description"))
                .andExpect(jsonPath("$.userId").value("user1"));
    }

    @Test
    void testGetAllByUser() throws Exception {
        Task task = new Task();
        task.setId("1");
        task.setTitle("Test Task");
        task.setDescription("Description");
        task.setUserId("user1");

        List<Task> tasks = Collections.singletonList(task);
        when(taskService.getAllByUser("user1")).thenReturn(tasks);

        mockMvc.perform(get("/user1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].title").value("Test Task"))
                .andExpect(jsonPath("$[0].description").value("Description"))
                .andExpect(jsonPath("$[0].userId").value("user1"));
    }

    @Test
    void testGetById() throws Exception {
        Task task = new Task();
        task.setId("1");
        task.setTitle("Test Task");
        task.setDescription("Description");
        task.setUserId("user1");

        when(taskService.getById("1")).thenReturn(task);

        mockMvc.perform(get("/getTask/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.title").value("Test Task"))
                .andExpect(jsonPath("$.description").value("Description"))
                .andExpect(jsonPath("$.userId").value("user1"));
    }

    @Test
    void testDelete() throws Exception {
        when(taskService.delete("1")).thenReturn("Task deleted");

        mockMvc.perform(delete("/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Task deleted"));
    }

    @Test
    void testUpdateTask() throws Exception {
        Task task = new Task();
        task.setId("1");
        task.setTitle("Updated Task");
        task.setDescription("Updated Description");
        task.setUserId("user1");

        //when(taskService.updateTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(put("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.title").value("Updated Task"))
                .andExpect(jsonPath("$.description").value("Updated Description"))
                .andExpect(jsonPath("$.userId").value("user1"));
    }*/
}
