package com.example.todolist.controller;

import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepos userRepos;
    @PostMapping
    public ResponseEntity registration(@RequestBody User user) {
        try{
//            if (UserRepos.findByUsername(user.getUsername()) != null){
//                return ResponseEntity.badRequest().body("Произошла ошибка");
//            }
            userRepos.save(user);
            return ResponseEntity.ok("Пользователь сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/")
    public ResponseEntity getUsers(){
        try{
            return ResponseEntity.ok("Сервер работает");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
