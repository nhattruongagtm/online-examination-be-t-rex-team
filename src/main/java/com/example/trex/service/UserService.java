package com.example.trex.service;

public interface UserService {
    String forgotPassword(String email);
    String resetPassword(String token, String password);
}
