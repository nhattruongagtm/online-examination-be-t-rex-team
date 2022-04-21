package com.example.trex.service.impl;

import com.example.trex.model.User;
import com.example.trex.repository.AuthRespository;
import com.example.trex.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthRespository authRespository;
    @Override
    public User login(String username, String password) {
        User user = authRespository.findByUsernameAndPassword(username,password);
        if(user != null){
            return user;
        }
      return null;
    }

    @Override
    public User signUp(User user) {
        User check = authRespository.findByUsername(user.getUsername());
        if(check == null) {
            User u = authRespository.save(user);
            if (u.getId() != null) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return authRespository.findAll();
    }

}
