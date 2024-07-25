package com.edsoft.ToDoList.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.List;

@Document
@Data
public class User {
    @Id
    private String id;

    private String userName;

    private String password;

    private String jwtToken;

    private String name;

    private String surname;

    private String email;

    @Field
    private List<String> taskIds;
}