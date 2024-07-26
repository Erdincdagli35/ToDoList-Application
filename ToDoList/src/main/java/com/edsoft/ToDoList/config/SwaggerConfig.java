package com.edsoft.ToDoList.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        return new OpenAPI()
                .info(apiInfo())
                .servers(apiServers());
    }

    @Bean
    public Info apiInfo() {
        return new Info()
                .title("Employee Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage employees.")
                .contact(apiContact());
    }

    @Bean
    public Contact apiContact() {
        return new Contact()
                .name("Erdinç Dağlı")
                .email("erdincdagli35@hotmail.com");
    }

    @Bean
    public List<Server> apiServers() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        return List.of(server);
    }
}