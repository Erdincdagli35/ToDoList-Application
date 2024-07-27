package com.edsoft.ToDoList.repository;

import com.edsoft.ToDoList.models.Counter;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CouchbaseRepository<Counter, String> {
}