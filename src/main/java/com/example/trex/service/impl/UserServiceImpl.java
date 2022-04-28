package com.example.trex.service.impl;

import com.example.trex.model.User;
import com.example.trex.repository.UserRepository;
import com.example.trex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trex.service.MailService;
import com.example.trex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
    @Autowired
    MailService mailService;
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
    @Override
    public String forgotPassword(String email) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if(!userOptional.isPresent()){
            return "Invalid email";
        }
        User user = userOptional.get();
        user.setTokenCreationDate(LocalDateTime.now());
        user.setToken(generateToken());
        userRepository.save(user);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Password Reset Request");
        msg.setText("To reset your password, click the link below: \n"+"http://localhost:3000/dat-lai-mat-khau?token="+user.getToken());

        mailService.sendEmail(msg);
        return "Please check your email to reset password";
    }

    @Override
    public String resetPassword(String token, String password) {
        Optional<User> userOptional= Optional.ofNullable(userRepository.findByToken(token));
        if(!userOptional.isPresent()){
            return "Invalid token";
        }


        User user = userOptional.get();
        if(isTokenExpired(user.getTokenCreationDate())){
            return "Token Expired";
        }
        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);
        userRepository.save(user);
        return "Your password successfull update";
    }

    @Override
    public User addStudent(User u) {
        return userRepository.save(u);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getUsers() {
        List<User> u = new ArrayList<>();
        List<User> u1 = userRepository.findAll();
        for (int i = 0; i < u1.size(); i++) {
            if (u1.get(i).getType() == 0) {
                u.add(u1.get(i));
            }
        }
        return u;
    }

    public String generateToken(){
        StringBuilder token = new StringBuilder();
        return token.append(
                UUID.randomUUID().toString().replace("-","")
        ).toString();
    }
    public boolean isTokenExpired(LocalDateTime tokenCreationDate){
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate,now);
        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
