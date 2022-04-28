package com.example.trex.controllers;

import com.example.trex.model.ResponseObject;
import com.example.trex.model.User;
import com.example.trex.repository.UserRepository;
import com.example.trex.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/user")
public class ForgotPasswordController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/forgot-password")
    ResponseEntity<ResponseObject> forgotPassword(@RequestParam String email){
        String message = service.forgotPassword(email);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "ok",
                        message,
                        ""
                )
        );
    }

    @GetMapping("/reset-password")
    ResponseEntity<ResponseObject> resetPassword(@RequestParam String token,
                                                 @RequestParam String password){
        String message = service.resetPassword(token, password);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "ok",
                        message,
                        ""
                )
        );
    }

    @Autowired
    UserRepository repository;
    @GetMapping("/save-user")
    public User saveUser(){
        User user = new User("tanhuynh", "123456", "hntan2000@gmail.com");
        return repository.save(user);
    }
}
