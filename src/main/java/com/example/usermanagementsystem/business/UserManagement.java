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

    public Optional<User> updateUserById(Long userId, User updatedUser){

       return userRepository.findById(userId).map((user)->{
           user.setUserName(updatedUser.getUserName());
           user.setEmail(updatedUser.getEmail());
           user.setName(updatedUser.getName());
           return userRepository.save(user);
       });

    }

    public User getUserById(Long userId){

        User user = userRepository.findById(userId).get();
        return user;
    }


}
