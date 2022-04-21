package com.example.trex.controllers;

import com.example.trex.dto.AuthDTO;
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
    public AuthDTO Login(@RequestBody User user){
        User u = authService.login(user.getUsername(),user.getPassword());
        AuthDTO dto = new AuthDTO();
        dto.setId(u.getId());
        dto.setName("Nguyen Van A");
        dto.setPhotoUrl("");
        dto.setType(0);
        return dto;
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
