package com.example.usermanagementsystem.business;

import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManagement {

    @Autowired
    private UserRepository userRepository;

    public User updateUserById(Long userId,User updatedUser){

        User user = userRepository.findById(userId).get();

        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());
        user.setName(updatedUser.getName());

        userRepository.save(user);


        return user;
    }


}
