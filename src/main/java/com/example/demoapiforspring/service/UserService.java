package com.example.demoapiforspring.service;

import com.example.demoapiforspring.entity.User;
import com.example.demoapiforspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String email, Double balance) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setBalance(balance);

        return userRepository.save(user);
    }
}
