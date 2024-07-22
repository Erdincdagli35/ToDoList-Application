package com.edsoft.ToDoList.service;

import com.edsoft.ToDoList.mapping.UserMapping;
import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.pojo.UserPasswordChangePojo;
import com.edsoft.ToDoList.pojo.UserReturnPojo;
import com.edsoft.ToDoList.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private JwtUtil jwtUtil;

    @Autowired
    private UserMapping userMapping;

    @Override
    public UserReturnPojo singUp(User user) {
        log.info("User signed up with ID: {}", user.getId());
        //user.setJwtToken(generateToken(user.getName()));
        user = userRepository.save(user);
        return userMapping.mapUserToUserReturnPojo(user);
    }

    @Override
    public List<UserReturnPojo> getAll(String name, String password) {
        log.info("Getting all users");
        //List<User> users = getUsersByCriteria(name, password);
        List<User> users = userRepository.findAll();
        return userMapping.mapUsersToUserReturnsPojo(users);
    }

    @Override
    public User getById(Long userId) {
        log.info("Getting user by ID: {}", userId);
        return userRepository.findOneById(userId);
    }

    @Override
    public Long delete(Long userId) {
        log.info("Deleting user with ID: {}", userId);
        User user = getById(userId);
        userRepository.delete(user);
        return userId;
    }

    @Override
    public UserReturnPojo changePassword(UserPasswordChangePojo userPasswordChangePojo) {
        log.info("Changing password for user with name: {}", userPasswordChangePojo.getName());
        User user = userRepository.findOneByName(userPasswordChangePojo.getName()); //DB User
        user.setPassword(userPasswordChangePojo.getNewPassword());
        User savedUser = userRepository.save(user);
        return userMapping.mapUserToUserReturnPojo(savedUser);
    }

    @Override
    public UserReturnPojo login(User user) {
        log.info("User logged in with user.name: {}", user.getName());
        return userMapping.mapUserToUserReturnPojo(user);
    }

    /*
    public List<User> getUsersByCriteria(String name, String password) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(builder.equal(root.get("name"), name));
        }

        if (password != null) {
            predicates.add(builder.equal(root.get("password"), password));
        }

        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public String generateToken(String name) {
        return jwtUtil.generateToken(name);
    }*/
}
