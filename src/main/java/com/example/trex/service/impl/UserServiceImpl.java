package com.example.trex.service.impl;

import com.example.trex.model.User;
import com.example.trex.repository.UserRepository;
import com.example.trex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }
}
