package com.edsoft.ToDoList.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;



@Document
@Getter
@Setter
public class Task {
    @Id
    private String id;

    private String title;
    private String description;

    private Status status = Status.NoProgress;
    //private DateTime startDateTime;
    //private DateTime endDateTime;

    @Field
    private String userId;
}