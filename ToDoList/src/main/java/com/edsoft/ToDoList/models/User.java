package com.edsoft.ToDoList.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.List;

@Document
@Getter
@Setter
public class User {
    @Id
    private String id;

    private String name;
    private String password;

    @Field
    private List<String> taskIds;
    private String jwtToken;
}