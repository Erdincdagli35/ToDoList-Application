package com.edsoft.ToDoList.models;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Document
@Data
public class Task {
    @Id
    private String id;

    private String title;

    private String description;

    private Status status = Status.NoProgress;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Field
    private String userId;
}