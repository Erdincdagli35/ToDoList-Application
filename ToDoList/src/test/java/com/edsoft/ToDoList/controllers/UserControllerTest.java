package com.edsoft.ToDoList.controllers;


import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.service.UserService;
import com.edsoft.ToDoList.validation.UserValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserValidation userValidation;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
/*
    @Test
    void singUpUser_Success() {
        User user = new User();
        user.setId("1111");
        user.setUserName("testUser");

        // Mocking the behavior
        when(userValidation.existsUserByName(anyString())).thenReturn(true);
        when(userService.singUp(any(User.class))).thenReturn(user);

        // Performing the test
        ResponseEntity response = userController.singUp(user);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void loginUser_Success() {
        User user = new User();
        user.setUserName("testUser");
        user.setPassword("testPass");

        when(userValidation.existsUserByName(anyString())).thenReturn(true);
        when(userValidation.checkLogin(any(User.class))).thenReturn(true);
        when(userService.login(any(User.class))).thenReturn(user);

        ResponseEntity response = userController.login(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void loginUser_UserNotFound() {
        User user = new User();
        user.setUserName("testUser");
        user.setPassword("testPass");

        when(userValidation.existsUserByName(anyString())).thenReturn(false);

        ResponseEntity response = userController.login(user);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Same user exists", response.getBody());
    }

    @Test
    void getAllUsers() {
        User user1 = new User();
        user1.setUserName("testUser1");
        user1.setPassword("testPass1");

        User user2 = new User();
        user2.setUserName("testUser2");
        user2.setPassword("testPass2");

        List<User> users = Arrays.asList(user1, user2);
        when(userService.getAll(anyString(), anyString())).thenReturn(users);

        ResponseEntity<List<User>> response = userController.getAll(null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    void getUserByName_Success() {
        User user = new User();
        user.setUserName("testUser");

        when(userValidation.existsUserByName(anyString())).thenReturn(true);
        when(userService.getByName(anyString())).thenReturn(user);

        ResponseEntity response = userController.getByName("testUser");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void getUserByName_NotFound() {
        when(userValidation.existsUserByName(anyString())).thenReturn(false);

        ResponseEntity response = userController.getByName("testUser");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("An unexpected error occurred.", response.getBody());
    }

    @Test
    void deleteUser_Success() {
        String userId = "1";

        when(userValidation.existsUserById(anyString())).thenReturn(true);
        when(userService.delete(anyString())).thenReturn(String.valueOf(true));

        ResponseEntity response = userController.delete(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteUser_NotFound() {
        String userId = "1";

        when(userValidation.existsUserById(anyString())).thenReturn(false);

        ResponseEntity response = userController.delete(userId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("An unexpected error occurred.", response.getBody());
    }

    @Test
    void changePassword_Success() {
        UserPasswordChangePojo pojo = new UserPasswordChangePojo();
        pojo.setName("testUser");
        pojo.setOldPassword("oldPass");
        pojo.setNewPassword("newPass");
        pojo.setNewPasswordConfirm("newPass");

        when(userValidation.existsUserByName(anyString())).thenReturn(true);
        when(userValidation.oldPasswordCheck(anyString(), anyString())).thenReturn(true);
        when(userValidation.newPasswordCheck(any(UserPasswordChangePojo.class))).thenReturn(true);

        ResponseEntity response = userController.changePassword(pojo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void changePassword_InvalidOldPassword() {
        UserPasswordChangePojo pojo = new UserPasswordChangePojo();
        pojo.setName("testUser");
        pojo.setOldPassword("oldPass");
        pojo.setNewPassword("newPass");

        when(userValidation.existsUserByName(anyString())).thenReturn(true);
        when(userValidation.oldPasswordCheck(anyString(), anyString())).thenReturn(false);

        ResponseEntity response = userController.changePassword(pojo);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Old password not correct entered", response.getBody());
    }*/
}