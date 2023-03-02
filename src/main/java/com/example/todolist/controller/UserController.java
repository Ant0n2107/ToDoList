package com.example.todolist.controller;

import com.example.todolist.exceptions.UserAlreadyExistExc;
import com.example.todolist.exceptions.UserNotFoundExc;
import com.example.todolist.model.UserModel;
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
    public ResponseEntity registration(@RequestBody UserModel user) {
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
    public ResponseEntity getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundExc e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
