package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.models.Status;
import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.pojo.UserAndTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    String addTaskToUser(Task task, String userName);

    List<Task> getAllByUser(String userName);

    String delete(String taskId);

    UserAndTask updateTask(Task task);

    UserAndTask updateStatus(String taskId, Status status);

    Task getById(String taskId);

    List<Task> getAllByUserAndStatus(String userName, Status status);

    List<Task> getAllByUserAndTitle(String userName, String title);

    List<Task> getAllByUserAndStatusAndTitle(String userName, Status status, String title);
}
