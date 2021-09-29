package com.example.testTask2.controller;

import com.example.testTask2.model.User;
import com.example.testTask2.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable ("id") long userId){
        return userService.findById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.registration(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable ("id") long userId){
        return userService.update(user, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") long userId){
        userService.delete(userId);
    }

}