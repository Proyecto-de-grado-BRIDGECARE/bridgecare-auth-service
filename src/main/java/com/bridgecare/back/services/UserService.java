package com.bridgecare.back.services;

import com.bridgecare.back.models.entities.Users;
import com.bridgecare.back.repositories.UserRepository;
import com.bridgecare.back.security.services.JWTService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public Map<String, String> verify(Users user) {
        Authentication authentication = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(user.getUsername());
            return Map.of("token", token);
        } else {
            return Map.of("error", "Authentication failed");
        }
    }
}
