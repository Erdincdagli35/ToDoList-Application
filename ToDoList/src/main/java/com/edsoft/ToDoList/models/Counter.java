package com.edsoft.ToDoList.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Counter {
    @Id
    private String id;
    private Long value;
}
