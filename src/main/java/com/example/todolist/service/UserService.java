package com.example.todolist.service;

import com.example.todolist.exceptions.UserAlreadyExistExc;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepos userRepos;
    public User registration(User user) throws UserAlreadyExistExc {
        if (userRepos.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistExc("Пользователь с таким именем уже существует");
        }
        return userRepos.save(user);
    }
}
