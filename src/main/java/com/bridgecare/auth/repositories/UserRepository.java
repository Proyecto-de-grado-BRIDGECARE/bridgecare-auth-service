package com.bridgecare.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgecare.auth.models.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String email);
}
