package com.bridgecare.back.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bridgecare.back.models.entities.Users;
import com.bridgecare.back.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Users user) {
        return service.verify(user);
    }
}