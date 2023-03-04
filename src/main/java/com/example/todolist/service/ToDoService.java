package com.example.todolist.service;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.entity.UserEntity;
import com.example.todolist.model.ToDo;
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
    public ToDo createToDo(ToDoEntity todo, Long userid){
        UserEntity user = userRepos.findById(userid).get();
        todo.setUser(user);
        return ToDo.toModel(todoRepos.save(todo));
    }

    public ToDo completeToDo(Long id){
        ToDoEntity todo = todoRepos.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        return ToDo.toModel(todoRepos.save(todo));
    }
}
