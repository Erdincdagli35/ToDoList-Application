package com.edsoft.ToDoList.controllers;


import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.repository.UserRepository;
import com.edsoft.ToDoList.service.UserService;
import com.edsoft.ToDoList.validation.UserValidation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "User Controller", description = "User management APIs")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidation userValidation;

    @PostMapping("/singUp")
    @Operation(summary = "User Sign Up", description = "Register a new user in the system")
    public ResponseEntity singUp(@RequestBody User user) {
        if (!userValidation.existsUser(user)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("There is a user with the same id: " + user.getId() +
                            " or username: " + user.getName());
        }

        return ResponseEntity.ok(userService.singUp(user));
    }

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Authenticate a user")
    public ResponseEntity login(@RequestBody User user) {
        if (!userValidation.existsUserByName(user.getUserName())) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Same user exists");
        }

        if (!userValidation.checkLogin(user)) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Wrong password or username please check out again: \n" +
                            "User Name: " + user.getUserName() + " Password : " + user.getPassword());
        }

        return ResponseEntity.ok(userService.login(user));
    }

    @GetMapping
    @Operation(summary = "Get All Users", description = "Retrieve all users or filter by name and password")
    public ResponseEntity<List<User>> getAll(@RequestParam(required = false) String name,
                                                       @RequestParam(required = false) String password) {
        return ResponseEntity.ok(userService.getAll(name, password));
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get All Users", description = "Retrieve all users or filter by name")
    public ResponseEntity getByName(@PathVariable String name) {

        if (!userValidation.existsUserByName(name)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("An unexpected error occurred.");
        }

        return ResponseEntity.ok(userService.getByName(name));
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete User", description = "Delete a user by their ID")
    public ResponseEntity delete(@PathVariable String userId) {

        if (!userValidation.existsUserById(userId)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("An unexpected error occurred.");
        }

        return ResponseEntity.ok(userService.delete(userId));
    }

    @PutMapping("/changePassword")
    @Operation(summary = "Change User Password", description = "Change the password of a user")
    public ResponseEntity changePassword(@RequestBody UserPasswordChangePojo userPasswordChangePojo) {
            if (!userValidation.existsUserByName(userPasswordChangePojo.getName())) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("There is a same user");
            }

            if (!userValidation.oldPasswordCheck(userPasswordChangePojo.getName(), userPasswordChangePojo.getOldPassword())) {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Old password not correct entered");
        }

            if (!userValidation.newPasswordCheck(userPasswordChangePojo)) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Invalid new password error");
            }


        return ResponseEntity.ok(userService.changePassword(userPasswordChangePojo));
    }
}
