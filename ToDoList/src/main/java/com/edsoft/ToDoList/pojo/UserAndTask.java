package com.edsoft.ToDoList.pojo;

import com.edsoft.ToDoList.models.Status;
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
