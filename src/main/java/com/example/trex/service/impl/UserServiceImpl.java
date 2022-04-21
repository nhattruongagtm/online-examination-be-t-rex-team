package com.example.trex.service.impl;

import com.example.trex.model.User;
import com.example.trex.repository.UserRepository;
import com.example.trex.service.MailService;
import com.example.trex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
    @Autowired
    UserRepository repository;
    @Autowired
    MailService mailService;
    @Override
    public String forgotPassword(String email) {
        Optional<User> userOptional = Optional.ofNullable(repository.findByEmail(email));
        if(!userOptional.isPresent()){
            return "Invalid email";
        }
        User user = userOptional.get();
        user.setTokenCreationDate(LocalDateTime.now());
        user.setToken(generateToken());
        repository.save(user);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Password Reset Request");
        msg.setText("To reset your password, click the link below: \n"+"http://localhost:8080/user/reset-password?token="+user.getToken());

        mailService.sendEmail(msg);
        return "Please check your email to reset password";
    }

    @Override
    public String resetPassword(String token, String password) {
        Optional<User> userOptional= Optional.ofNullable(repository.findByToken(token));
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
        repository.save(user);
        return "Your password successfull update";
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
