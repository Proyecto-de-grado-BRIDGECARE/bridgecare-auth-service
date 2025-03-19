package com.bridgecare.auth.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bridgecare.common.models.entities.Usuario;
import com.bridgecare.auth.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService service;

    // Disable registering users
    // @PostMapping("/register")
    // public Usuario register(@RequestBody Usuario user) {
    //     return service.register(user);
    // }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario user) {
        return service.verify(user);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUser(@RequestHeader("Authorization") String authHeader) {
        return service.getUser(authHeader);
    }
}