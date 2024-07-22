package com.edsoft.ToDoList.models;

import lombok.Data;

@Data
public class UserAndTask {
    private String id;
    private String name;
    private String taskId;
    private String title;
    private String description;
    private Status status = Status.NoProgress;
}
