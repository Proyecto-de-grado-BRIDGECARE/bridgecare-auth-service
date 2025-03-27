package com.bridgecare.auth.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bridgecare.common.models.entities.Usuario;
import com.bridgecare.auth.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Optional<Usuario> optionalUser = userRepo.findByCorreo(correo);
        Usuario user = optionalUser.orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        return new UserPrincipal(user);
    }
}
