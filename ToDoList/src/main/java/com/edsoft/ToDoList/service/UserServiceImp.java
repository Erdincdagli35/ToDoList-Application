package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.mapping.UserMapping;
import com.edsoft.ToDoList.models.Counter;
import com.edsoft.ToDoList.models.Task;
import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.pojo.UserReturnPojo;
import com.edsoft.ToDoList.repository.CounterRepository;
import com.edsoft.ToDoList.repository.TaskRepository;
import com.edsoft.ToDoList.repository.UserRepository;
import com.edsoft.ToDoList.security.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapping userMapping;

    @Autowired
    private CounterRepository counterRepository;

    @Override
    public User singUp(User user) {
        log.info("User signed up with ID: {}", user.getId());
        user.setId(incrementCounter().toString());

        user = userRepository.save(user);
        return user;
    }

    private Long incrementCounter() {
        String counterId = "global_counter";
        Counter counter = counterRepository.findById(counterId)
                .orElse(new Counter(counterId, 0L));

        counter.setValue(counter.getValue() + 1);
        counterRepository.save(counter);
        return counter.getValue();
    }

    @Override
    public User login(User user) {
        log.info("User logged in with user.name: {}", user.getUserName());
        User userTemp = userRepository.findOneByUserName(user.getUserName());

        user.setJwtToken(jwtUtil.generateToken(user.getUserName()));
        user.setName(userTemp.getName());
        user.setSurname(userTemp.getSurname());
        user.setEmail(userTemp.getEmail());

        if (userTemp.getTaskIds() != null) {
            user.setTaskIds(userTemp.getTaskIds());
        }

        user.setId(userTemp.getId());

        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAll(String name, String password) {
        log.info("Getting all users");
        //List<User> users = getUsersByCriteria(name, password);
        List<User> users = userRepository.findAllByOrderByCreatedDateDesc();
        //return userMapping.mapUsersToUserReturnsPojo(users);
        return users;
    }

    @Override
    public User getById(String userId) {
        log.info("Getting user by ID: {}", userId);
        User user = userRepository.findOneById(userId);
        return user;
    }

    @Override
    public User getByName(String name) {
        return userRepository.findOneByUserName(name);
    }

    @Override
    public String delete(String userId) {
        log.info("Deleting user with ID: {}", userId);
        User user = getById(userId);
        userRepository.delete(user);
        return userId;
    }

    @Override
    public UserReturnPojo changePassword(UserPasswordChangePojo userPasswordChangePojo) {
        log.info("Changing password for user with name: {}", userPasswordChangePojo.getName());
        User user = userRepository.findOneByUserName(userPasswordChangePojo.getName()); //DB User
        user.setPassword(userPasswordChangePojo.getNewPassword());
        User savedUser = userRepository.save(user);
        return userMapping.mapUserToUserReturnPojo(savedUser);
    }

    public String generateToken(String name) {
        return jwtUtil.generateToken(name);
    }
}
