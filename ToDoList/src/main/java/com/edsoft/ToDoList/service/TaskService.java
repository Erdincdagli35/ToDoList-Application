package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.models.Status;
import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.models.UserAndTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    String addTaskToUser(Task task, String userName);

    List<Task> getAllByUser(String userName);

    String delete(String taskId);

    UserAndTask updateTask(Task task);

    UserAndTask updateStatus(String taskId, Status status);

    List<UserAndTask> getAll();

    List<Task> getAllByUserAndStatus(String userName, Status status);
}
