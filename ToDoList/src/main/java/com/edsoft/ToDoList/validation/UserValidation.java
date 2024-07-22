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
        return ((userRepository.findOneById(user.getId()) == null)
                && userRepository.findOneByName(user.getName()) == null);
    }

    public boolean existsUserById(String userId) {
        return userRepository.findOneById(userId) != null;
    }

    public boolean existsUserByName(String name) {
        return userRepository.findOneByName(name) != null;
    }

    public boolean oldPasswordCheck(String name, String oldPassword) {
        User user = userRepository.findOneByName(name);
        return user.getPassword().equals(oldPassword);
    }

    public boolean newPasswordCheck(UserPasswordChangePojo userPasswordChangePojo) {
        User user = userRepository.findOneByName(userPasswordChangePojo.name);

        //Firstly, We have to check oldPassword and new password. They should not be same.
        if (user.getPassword().equals(userPasswordChangePojo.newPassword)) {
            return false;
        }

        return userPasswordChangePojo.newPassword.equals(userPasswordChangePojo.newPasswordConfirm);
    }

    public boolean checkLogin(User user) {
        User userDB = userRepository.findOneByName(user.getName());
        return userDB.getName().equals(user.getName()) && userDB.getPassword().equals(user.getPassword());
    }
/*
    public boolean checkJwtToken(User user) {
        User userDB = userRepository.findOneByName(user.getName());
        return userDB.getJwtToken().equals(user.getJwtToken());
    }*/
}
