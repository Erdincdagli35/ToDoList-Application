package com.edsoft.ToDoList.repository;

import com.edsoft.ToDoList.models.Status;
import com.edsoft.ToDoList.models.Task;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CouchbaseRepository<Task, String> {
    Task findOneById(String id);
    Task findOneByIdOrderByCreatedDateDesc(String id);
    List<Task> findByIdInAndTitleContainingOrderByCreatedDateDesc(List<String> ids, String title);
    List<Task> findByIdInAndStatusAndTitleContainingOrderByCreatedDateDesc(List<String> ids, Status status, String title);
    List<Task> findAllByOrderByCreatedDateDesc();

    List<Task> findAllByStatusAndTitleContainingOrderByCreatedDateDesc(Status status, String title);

    List<Task> findAllByStatusOrderByCreatedDateDesc(Status status);

    List<Task> findAllByTitleContainingOrderByCreatedDateDesc(String title);

}
