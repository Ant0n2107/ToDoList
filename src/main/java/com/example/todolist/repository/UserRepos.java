package com.example.todolist.repository;

import com.example.todolist.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepos extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
