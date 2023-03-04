package com.example.todolist.controller;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity todo, Long userid){
        try {
            return ResponseEntity.ok(toDoService.createToDo(todo, userid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(toDoService.completeToDo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
