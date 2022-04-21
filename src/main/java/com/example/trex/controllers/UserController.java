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
}
