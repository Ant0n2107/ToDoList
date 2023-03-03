package com.example.todolist.repository;

import com.example.todolist.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepos extends CrudRepository<ToDoEntity, Long> {

}
