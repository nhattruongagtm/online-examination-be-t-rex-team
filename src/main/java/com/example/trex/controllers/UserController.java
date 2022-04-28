package com.example.trex.controllers;

import com.example.trex.model.Classes;
import com.example.trex.model.User;
import com.example.trex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserService userService;

//    http://localhost:8080/change-pass/1
    @PutMapping("/change-pass/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
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
    @PostMapping("/addStudent")
    public ResponseEntity<?> addUser(@RequestBody User u){
        if (u.getType() == 0){
            User user = userService.addStudent(u);
            return  ResponseEntity.ok("ok");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
    }
    @GetMapping("/getUserByID/{id}")
    public ResponseEntity getUserById(@PathVariable(name = "id") Long id){
        User result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }



}
