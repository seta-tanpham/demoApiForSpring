package com.example.demoapiforspring.controller;

import com.example.demoapiforspring.entity.User;
import com.example.demoapiforspring.service.UserService;
import dto.UserCreateRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.createUser(
                userCreateRequest.getUsername(),
                userCreateRequest.getEmail(),
                userCreateRequest.getBalance()
        );
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
