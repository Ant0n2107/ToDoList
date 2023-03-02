package com.example.todolist.repository;

import com.example.todolist.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepos extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
