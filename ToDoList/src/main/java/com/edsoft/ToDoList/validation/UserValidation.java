package com.edsoft.ToDoList.validation;

import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.repository.UserRepository;
import com.edsoft.ToDoList.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    public boolean existsUser(User user) {
        return ((userRepository.findOneById(user.getId()) != null)
                && userRepository.findOneByUserName(user.getUserName()) != null);
    }

    public boolean existsUserById(String userId) {
        return userRepository.findOneById(userId) != null;
    }

    public boolean existsUserByName(String name) {
        return userRepository.findOneByUserName(name) != null;
    }

    public boolean oldPasswordCheck(String name, String oldPassword) {
        User user = userRepository.findOneByUserName(name);
        return user.getPassword().equals(oldPassword);
    }

    public boolean newPasswordCheck(UserPasswordChangePojo userPasswordChangePojo) {
        User user = userRepository.findOneByUserName(userPasswordChangePojo.name);

        //Firstly, We have to check oldPassword and new password. They should not be same.
        if (user.getPassword().equals(userPasswordChangePojo.newPassword)) {
            return false;
        }

        return userPasswordChangePojo.newPassword.equals(userPasswordChangePojo.newPasswordConfirm);
    }

    public boolean checkLogin(User user) {
        User userDB = userRepository.findOneByUserName(user.getUserName());
        return userDB.getUserName().equals(user.getUserName()) && userDB.getPassword().equals(user.getPassword());
    }
/*
    public boolean checkJwtToken(User user) {
        User userDB = userRepository.findOneByName(user.getName());
        return userDB.getJwtToken().equals(user.getJwtToken());
    }*/
}
