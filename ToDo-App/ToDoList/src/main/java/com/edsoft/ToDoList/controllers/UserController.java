package com.edsoft.ToDoList.controllers;


import com.edsoft.ToDoList.exception.*;
import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.pojo.UserReturnPojo;
import com.edsoft.ToDoList.repository.UserRepository;
import com.edsoft.ToDoList.service.UserService;
import com.edsoft.ToDoList.validation.UserValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidation userValidation;

    @PostMapping("/singUp")
    public ResponseEntity singUp(@RequestBody User user) {
        /*try {
            if (!userValidation.existsUser(user)) {
                throw new UserValidationException("There is a user with the same id: " + user.getId() +
                        " or username: " + user.getName());
            }
        } catch (UserValidationException e) {
            log.error("User validation error: {}", e.getMessage());
            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error during user validation: {}", e.getMessage());
            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred.");
        }*/

        return ResponseEntity.ok(userService.singUp(user));
    }

    @GetMapping
    public ResponseEntity<List<UserReturnPojo>> getAll(@RequestParam(required = false) String name,
                                                       @RequestParam(required = false) String password) {
        return ResponseEntity.ok(userService.getAll(name, password));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity delete(@PathVariable Long userId) {
        try {
            if (!userValidation.existsUserById(userId)) {
                throw new UserNotFoundException(userId);
            }
        } catch (UserValidationException e) {
            log.error("User validation error: {}", e.getMessage());
            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error during user validation: {}", e.getMessage());
            e.printStackTrace();

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred.");
        }

        return ResponseEntity.ok(userService.delete(userId));
    }

    @PutMapping("/changePassword")
    public ResponseEntity changePassword(@RequestBody UserPasswordChangePojo userPasswordChangePojo) {
        try {
            if (!userValidation.existsUserByName(userPasswordChangePojo.getName())) {
                throw new UserNotFoundException(userPasswordChangePojo.getName());
            }
        } catch (UserNotFoundException e) {
            log.error("User not found error: {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

        try {
            if (!userValidation.oldPasswordCheck(userPasswordChangePojo.getName(), userPasswordChangePojo.getOldPassword())) {
                throw new InvalidOldPasswordException();
            }
        } catch (InvalidOldPasswordException e) {
            log.error("Invalid old password error: {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }

        try {
            if (!userValidation.newPasswordCheck(userPasswordChangePojo)) {
                throw new InvalidNewPasswordException();
            }
        } catch (InvalidNewPasswordException e) {
            log.error("Invalid new password error: {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }


        return ResponseEntity.ok(userService.changePassword(userPasswordChangePojo));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        try {
            if (!userValidation.existsUserByName(user.getName())) {
                throw new UserNotFoundException(user.getName());
            }
        } catch (UserNotFoundException e) {
            log.error("User not found error: {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }


        try {
            if (!userValidation.checkJwtToken(user)) {
                throw new UserLoginCheckException("Jwt token did not match");
            }
        } catch (UserLoginCheckException e) {
            log.error("Jwt token did not match : ", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Jwt token did not match");
        }

        try {
            if (!userValidation.checkLogin(user)) {
                throw new UserLoginCheckException("Login failed");
            }
        } catch (UserLoginCheckException e) {
            log.error("User did not log in error: {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Wrong password or username please check out again: \n" +
                            "User Name: " + user.getName() + " Password : " + user.getPassword());
        }

        return ResponseEntity.ok(userService.login(user));
    }
}
