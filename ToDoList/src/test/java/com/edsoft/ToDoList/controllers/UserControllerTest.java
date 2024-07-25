package com.edsoft.ToDoList.controllers;

import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.repository.UserRepository;
import com.edsoft.ToDoList.service.UserService;
import com.edsoft.ToDoList.validation.UserValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository; // Mock repository bean

    @MockBean
    private UserService userService;

    @MockBean
    private UserValidation userValidation;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
/*
    @Test
    public void testSignUpUser() throws Exception {
        User user = new User();
        user.setId("123");
        user.setUserName("testUser");
        user.setPassword("password");
        user.setName("Test");
        user.setSurname("test");
        user.setEmail("email@example.com");

        when(userValidation.existsUser(any(User.class))).thenReturn(false);
        when(userService.singUp(any(User.class))).thenReturn(user);

        String userJson = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/singUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(content().json(userJson));

        verify(userValidation).existsUser(user);
        verify(userService).singUp(user);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        User user = new User();
        user.setUserName("testUser");
        List<User> users = Arrays.asList(user);

        when(userService.getAll(null, null)).thenReturn(users);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(users)));

        verify(userService).getAll(null, null);
    }

    @Test
    public void testGetUserByName() throws Exception {
        User user = new User();
        user.setUserName("testUser");

        when(userValidation.existsUserByName(any(String.class))).thenReturn(true);
        when(userService.getByName(any(String.class))).thenReturn(user);

        mockMvc.perform(get("/testUser"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(user)));

        verify(userValidation).existsUserByName("testUser");
        verify(userService).getByName("testUser");
    }

    @Test
    public void testDeleteUser() throws Exception {
        when(userValidation.existsUserById(any(String.class))).thenReturn(true);
        doNothing().when(userService).delete(any(String.class));

        mockMvc.perform(delete("/123"))
                .andExpect(status().isOk());

        verify(userValidation).existsUserById("123");
        verify(userService).delete("123");
    }

    @Test
    public void testChangePassword() throws Exception {
        UserPasswordChangePojo changePojo = new UserPasswordChangePojo();
        changePojo.setName("testUser");
        changePojo.setOldPassword("oldPass");
        changePojo.setNewPassword("newPass");

        when(userValidation.existsUserByName(any(String.class))).thenReturn(true);
        when(userValidation.oldPasswordCheck(any(String.class), any(String.class))).thenReturn(true);
        when(userValidation.newPasswordCheck(any(UserPasswordChangePojo.class))).thenReturn(true);
        when(userService.changePassword(any(UserPasswordChangePojo.class)));

        mockMvc.perform(put("/changePassword")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(changePojo)))
                .andExpect(status().isOk())
                .andExpect(content().string("Password changed"));

        verify(userValidation).existsUserByName("testUser");
        verify(userValidation).oldPasswordCheck("testUser", "oldPass");
        verify(userValidation).newPasswordCheck(changePojo);
        verify(userService).changePassword(changePojo);
    }

    @Test
    public void testLoginUser() throws Exception {
        User user = new User();
        user.setUserName("testUser");
        user.setPassword("password123");

        when(userValidation.existsUserByName(any(String.class))).thenReturn(true);
        when(userValidation.checkLogin(any(User.class))).thenReturn(true);
        when(userService.login(any(User.class)));

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("Login successful"));

        verify(userValidation).existsUserByName("testUser");
        verify(userValidation).checkLogin(user);
        verify(userService).login(user);
    }*/
}
