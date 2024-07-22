package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.pojo.UserReturnPojo;

import java.util.List;

public interface UserService {
    User singUp(User user);

    User login(User user);

    UserReturnPojo changePassword(UserPasswordChangePojo userPasswordChangePojo);

    List<User> getAll(String name, String password);

    String delete(String userId);

    User getById(String userId);

    User getByName(String name);

}
