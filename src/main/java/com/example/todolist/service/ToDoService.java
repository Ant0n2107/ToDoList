package com.example.todolist.service;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.entity.UserEntity;
import com.example.todolist.repository.ToDoRepos;
import com.example.todolist.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepos todoRepos;

    @Autowired
    private UserRepos userRepos;
    public ToDoEntity createToDo(ToDoEntity todo, Long userid){
        UserEntity user = userRepos.findById(userid).get();
        todo.setUser(user);
        return todoRepos.save(todo);
    }

    public ToDoEntity completeToDo(Long id){
        ToDoEntity todo = todoRepos.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        return todoRepos.save(todo);
    }
}
