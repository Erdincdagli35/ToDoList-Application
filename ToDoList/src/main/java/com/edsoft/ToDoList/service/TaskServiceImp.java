package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.models.Status;
import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.models.UserAndTask;
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
        User user = userRepository.findOneByName(userName);
        List<String> taskIds = new ArrayList<>();

        if (user.getTaskIds() == null) {
            taskIds.add(task.getId());
            user.setTaskIds(taskIds);
            task.setUserName(user.getId());
        } else if (user.getTaskIds() != null) {
            taskIds = user.getTaskIds();
            task.setUserName(user.getId());

            taskIds.add(task.getId());
            user.setTaskIds(taskIds);
        }

        taskRepository.save(task);
        userRepository.save(user);
        return task.getId();
    }

    /*
    @Override
    public List<UserAndTask> getAllByUser(String userName) {
        User user = userRepository.findOneByName(userName);
        List<Task> taskList = new ArrayList<>();
        List<UserAndTask> userAndTasksList = new ArrayList<>();
        if (user != null) {
            List<String> taskIdsList = user.getTaskIds();
            Task task = new Task();
            for (String taskId : taskIdsList) {
                task = taskRepository.findOneById(taskId);
                taskList.add(task);
            }

            for (Task t : taskList) {
                if (user.getId().equals(t.getUserId())) {
                    UserAndTask userAndTask = new UserAndTask();

                    userAndTask.setId(user.getId());
                    userAndTask.setName(user.getName());
                    userAndTask.setTaskId(task.getId());
                    userAndTask.setTitle(t.getTitle());
                    userAndTask.setStatus(t.getStatus());
                    userAndTask.setDescription(t.getDescription());

                    userAndTasksList.add(userAndTask);
                }
            }
        }

        return userAndTasksList;
    }*/

    @Override
    public List<Task> getAllByUser(String userName) {
        User user = userRepository.findOneByName(userName);
        List<Task> taskList = new ArrayList<>();
        List<UserAndTask> userAndTasksList = new ArrayList<>();
        if (user != null) {
            List<String> taskIdsList = user.getTaskIds();
            Task task = new Task();
            for (String taskId : taskIdsList) {
                task = taskRepository.findOneById(taskId);
                taskList.add(task);
            }
            /*
            for (Task t : taskList) {
                if (user.getId().equals(t.getUserId())) {
                    UserAndTask userAndTask = new UserAndTask();

                    userAndTask.setId(user.getId());
                    userAndTask.setName(user.getName());
                    userAndTask.setTaskId(task.getId());
                    userAndTask.setTitle(t.getTitle());
                    userAndTask.setStatus(t.getStatus());
                    userAndTask.setDescription(t.getDescription());

                    userAndTasksList.add(userAndTask);
                }
            }*/

        }

        return taskList;
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
    public List<UserAndTask> getAll() {
        List<User> userList = userRepository.findAll();
        List<Task> taskList = taskRepository.findAll();
        List<UserAndTask> userAndTaskList = new ArrayList<>();

        for (User user : userList) {
            for (Task task : taskList) {
                UserAndTask userAndTask = new UserAndTask();

                userAndTask.setId(user.getId());
                userAndTask.setName(user.getName());
                userAndTask.setTaskId(task.getId());
                userAndTask.setStatus(task.getStatus());
                userAndTask.setTitle(task.getTitle());
                userAndTask.setDescription(task.getDescription());

                userAndTaskList.add(userAndTask);
            }
        }

        return userAndTaskList;
    }
}
