package com.example.trex.controllers;

import com.example.trex.model.User;
import com.example.trex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    //open setting handler
    @Autowired
    UserService userService;

//    http://localhost:8080/change-pass/1
    @PutMapping("/change-pass/{id}")
    public User changePass(@PathVariable(value = "id") Long id,@RequestBody String pass){
        User u = userService.getUserByID(id);
        if(u!=null){
            u.setPassword(pass);
            userService.save(u);
            return u;
        }
        return null;
    }
//    just edit user data
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable(value = "id") Long id,@RequestBody User u){
        User user = userService.getUserByID(id);
        if(user!=null){
            user.setFullName(u.getFullName());
            user.setPhotoUrl(u.getPhotoUrl());
            user.setEmail(u.getEmail());
            user.setType(u.getType());

            return userService.save(user);
        }
        return null;
    }
}
