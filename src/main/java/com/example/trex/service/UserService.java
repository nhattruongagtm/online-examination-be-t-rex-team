package com.example.trex.service;

import com.example.trex.model.User;

public interface UserService {
    User getUserByID(Long id);

    User save(User u);
}
