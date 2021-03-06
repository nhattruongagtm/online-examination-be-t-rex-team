package com.example.trex.service;

import com.example.trex.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {
    User getUserByID(Long id);
    User save(User u);
    String forgotPassword(String email);
    String resetPassword(String token, String password);
    User addStudent(User u);
    User getUserById(Long id);
    List<User> getUsers();
    List<User> getUserByClassID(long classID);

    List<User> getUserByType();

}
