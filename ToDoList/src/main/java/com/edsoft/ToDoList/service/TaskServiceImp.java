package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.models.Status;
import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserAndTask;
import com.edsoft.ToDoList.repository.TaskRepository;
import com.edsoft.ToDoList.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addTaskToUser(Task task, String userName) {
        User user = userRepository.findOneByUserName(userName);
        List<String> taskIds;

        if (user.getTaskIds() != null){
            taskIds = new ArrayList<>();
        }

        taskIds = user.getTaskIds();

        if (taskIds == null) {
            taskIds = new ArrayList<>();
            user.setTaskIds(taskIds);
        }

        taskRepository.save(task);  // Save the task first to generate its ID

        taskIds.add(task.getId());  // Ensure the task ID is added after the task is saved
        user.setTaskIds(taskIds);

        userRepository.save(user);  // Save the user with the updated task IDs list
        return task.getId();
    }


    @Override
    public List<Task> getAllByUser(String userName) {
        User user = userRepository.findOneByUserName(userName);
        List<Task> taskList = new ArrayList<>();

        if (user != null) {
            List<String> taskIdsList = user.getTaskIds();
            if (taskIdsList != null) {
                for (String taskId : taskIdsList) {
                    Task task = taskRepository.findOneByIdOrderByCreatedDateDesc(taskId);
                    if (task != null) {
                        taskList.add(task);
                    }
                }
            }
        }

        return taskList;
    }

    @Override
    public List<Task> getAllByUserAndStatus(String userName, Status status) {
        User user = userRepository.findOneByUserName(userName);
        List<Task> taskList = new ArrayList<>();

        if (user != null) {
            List<String> taskIdsList = user.getTaskIds();
            if (taskIdsList != null) {
                for (String taskId : taskIdsList) {
                    Task task = taskRepository.findOneByIdOrderByCreatedDateDesc(taskId);
                    if (task != null && task.getStatus() == status) {
                        taskList.add(task);
                    }
                }
            }
        }

        return taskList;
    }

    @Override
    public List<Task> getAllByUserAndTitle(String userName, String title) {
        User user = userRepository.findOneByUserName(userName);
        if (user != null && user.getTaskIds() != null) {
            return taskRepository.findByIdInAndTitleContainingOrderByCreatedDateDesc(user.getTaskIds(), title);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Task> getAllByUserAndStatusAndTitle(String userName, Status status, String title) {
        User user = userRepository.findOneByUserName(userName);
        if (user != null && user.getTaskIds() != null) {
            return taskRepository.findByIdInAndStatusAndTitleContainingOrderByCreatedDateDesc(user.getTaskIds(), status, title);
        }
        return new ArrayList<>();
    }

    @Override
    public String delete(String taskId) {
        Task task = taskRepository.findOneById(taskId);
        String userId = task.getUserId();
        User user = userRepository.findOneById(userId);
        List<String> taskIds = user.getTaskIds();

        taskIds.remove(taskId);
        user.setTaskIds(taskIds);

        userRepository.save(user);
        taskRepository.delete(task);
        return taskId;
    }

    @Override
    public UserAndTask updateTask(Task task) {
        Task tempTask = taskRepository.findOneById(task.getId());
        User user = userRepository.findOneById(tempTask.getUserId());
        UserAndTask userAndTask = new UserAndTask();

        tempTask.setId(task.getId());
        tempTask.setTitle(task.getTitle());
        tempTask.setDescription(task.getDescription());
        tempTask.setStatus(task.getStatus());
        tempTask.setUserId(task.getUserId());

        taskRepository.save(tempTask);

        userAndTask.setName(user.getName());
        userAndTask.setTitle(tempTask.getTitle());
        userAndTask.setDescription(tempTask.getDescription());
        userAndTask.setStatus(tempTask.getStatus());

        return userAndTask;
    }

    @Override
    public UserAndTask updateStatus(String taskId, Status status) {
        Task task = taskRepository.findOneById(taskId);
        User user = userRepository.findOneById(task.getUserId());
        UserAndTask userAndTask = new UserAndTask();

        task.setStatus(status);
        taskRepository.save(task);

        userAndTask.setName(user.getName());
        userAndTask.setTitle(task.getTitle());
        userAndTask.setDescription(task.getDescription());
        userAndTask.setStatus(task.getStatus());

        return userAndTask;
    }

    @Override
    public Task getById(String taskId) {
        return taskRepository.findOneById(taskId);
    }
}
