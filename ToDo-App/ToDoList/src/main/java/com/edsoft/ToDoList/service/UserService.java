package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.pojo.UserReturnPojo;

import java.util.List;

public interface UserService {
    UserReturnPojo singUp(User user);

    List<UserReturnPojo> getAll(String name, String password);

    User getById(Long userId);

    Long delete(Long userId);

    UserReturnPojo changePassword(UserPasswordChangePojo userPasswordChangePojo);

    UserReturnPojo login(User user);
}
