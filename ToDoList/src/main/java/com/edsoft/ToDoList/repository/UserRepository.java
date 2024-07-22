package com.edsoft.ToDoList.repository;

import com.edsoft.ToDoList.models.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CouchbaseRepository<User, String> {

    List<User> findAll();

    User findOneById(String id);

    User findOneByName(String name);
}
