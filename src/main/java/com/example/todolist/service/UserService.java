package com.example.todolist.service;

import com.example.todolist.exceptions.UserAlreadyExistExc;
import com.example.todolist.exceptions.UserNotFoundExc;
import com.example.todolist.entity.UserEntity;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepos userRepos;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistExc {
        if (userRepos.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistExc("Пользователь с таким именем уже существует");
        }
        return userRepos.save(user);
    }

    public User getOne(Long id) throws UserNotFoundExc {
        UserEntity user = userRepos.findById(id).get();
        if (user == null) {
            throw new UserNotFoundExc("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long deleteOne(Long id){
        userRepos.deleteById(id);
        return id;
    }
}
