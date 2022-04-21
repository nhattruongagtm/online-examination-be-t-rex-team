package com.example.trex.controllers;

import com.example.trex.model.User;
import com.example.trex.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public boolean Login(@RequestBody User user){
        return authService.login(user.getUsername(),user.getPassword());

    }
    @PostMapping("/signup")
    public User SignUp(@RequestBody User user){
        return authService.signUp(user);
    }
    @GetMapping("/getAll")
    public List<User> getAll(){
        return authService.getAll();
    }


}
