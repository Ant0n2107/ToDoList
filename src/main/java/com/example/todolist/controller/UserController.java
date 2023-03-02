package com.example.todolist.controller;

import com.example.todolist.exceptions.UserAlreadyExistExc;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepos;
import com.example.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;
    @PostMapping
    public ResponseEntity registration(@RequestBody User user) {
        try{
            userService.registration(user);
            return ResponseEntity.ok("Пользователь сохранен");
        } catch (UserAlreadyExistExc e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping
    public ResponseEntity getUsers(){
        try{
            return ResponseEntity.ok("Сервер работает");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
