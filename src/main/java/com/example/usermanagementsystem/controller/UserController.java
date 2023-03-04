package com.example.usermanagementsystem.controller;

import com.example.usermanagementsystem.business.UserManagement;
import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserManagement userManagement;

    @PostMapping("/user")
    public User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUserByIds(@PathVariable Long userId){
        return userRepository.findById(userId);
    }

    @PutMapping("/user/update/{userId}")
    public User putUserByID(@PathVariable Long userId,@RequestBody User updatedUser){

        return userManagement.updateUserById(userId,updatedUser);
    }

}
