package com.example.todolist.repository;

import com.example.todolist.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepos extends CrudRepository<User, Long> {
}
