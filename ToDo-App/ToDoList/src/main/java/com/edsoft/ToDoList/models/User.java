package com.edsoft.ToDoList.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Getter
@Setter
public class User {
    @Id
    private Long id;

    private String name;
    private String password;
    private String jwtToken;
}