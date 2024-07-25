package com.edsoft.ToDoList.repository;

import com.edsoft.ToDoList.models.Task;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CouchbaseRepository<Task, String> {
    Task findOneById(String id);

    Task findOneByTitle(String title);

    List<Task> findAll();

    List<Task> findByUserIdAndStatus(String taskId);
}
