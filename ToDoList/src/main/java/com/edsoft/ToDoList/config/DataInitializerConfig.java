package com.edsoft.ToDoList.config;

import com.edsoft.ToDoList.models.User;
import com.edsoft.ToDoList.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializerConfig {

    @Bean
    public CommandLineRunner initializeData(UserRepository userRepository) {
        return args -> {
            if (userRepository.findOneByUserName("admin") == null) {
                User admin = new User();
                admin.setId("0");
                admin.setUserName("admin");
                admin.setPassword("admin");
                admin.setName("admin");
                admin.setSurname("admin");
                userRepository.save(admin);
            }
        };
    }
}