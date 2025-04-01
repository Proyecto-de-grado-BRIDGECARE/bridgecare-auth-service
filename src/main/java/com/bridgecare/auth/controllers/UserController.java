package com.bridgecare.auth.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bridgecare.common.models.dtos.UsuarioDTO;
import com.bridgecare.common.models.entities.Usuario;
import com.bridgecare.auth.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody Usuario user) {
    try {
        Usuario saved = service.register(user);
        return ResponseEntity.ok(service.toDto(saved));
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    @GetMapping("/users")
    public List<UsuarioDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/search")
    public List<UsuarioDTO> searchUsers(@RequestParam String query) {
        return service.searchUsers(query);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UsuarioDTO> updateUser(@PathVariable Long id, @RequestBody Usuario user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }
}