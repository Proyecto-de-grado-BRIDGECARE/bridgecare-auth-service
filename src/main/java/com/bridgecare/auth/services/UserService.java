package com.bridgecare.auth.services;

import org.springframework.stereotype.Service;

import com.bridgecare.common.models.entities.Usuario;
import com.bridgecare.common.models.dtos.UsuarioDTO;
import com.bridgecare.auth.repositories.UserRepository;
import com.bridgecare.auth.security.services.JWTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Usuario register(Usuario user) {
        if (repo.findByCorreo(user.getCorreo()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese correo.");
        }

        user.setContrasenia(encoder.encode(user.getContrasenia()));
        repo.save(user);
        return user;
    }

    public Map<String, String> verify(Usuario user) {
        Authentication authentication = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getCorreo(), user.getContrasenia())
        );

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(user.getCorreo());
            return Map.of("token", token);
        } else {
            return Map.of("error", "Authentication failed");
        }
    }

    public ResponseEntity<?> getUser(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or missing token");
        }

        String token = authHeader.substring(7); // Remove "Bearer " prefix
        String username;

        try {
            username = jwtService.extractUserName(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        Optional<Usuario> optionalUser = repo.findByCorreo(username);
        Usuario user = optionalUser.orElseThrow(() -> new IllegalArgumentException("User not found"));

        UsuarioDTO usuarioDTO = new UsuarioDTO(user.getId(), user.getNombres(), user.getApellidos(), user.getIdentificacion(), user.getTipoUsuario(), user.getCorreo(), user.getMunicipio());

        return ResponseEntity.ok(usuarioDTO);
    }

    public UsuarioDTO toDto(Usuario user) {
        return new UsuarioDTO(
                user.getId(),
                user.getNombres(),
                user.getApellidos(),
                user.getIdentificacion(),
                user.getTipoUsuario(),
                user.getCorreo(),
                user.getMunicipio()
        );
    }
}
