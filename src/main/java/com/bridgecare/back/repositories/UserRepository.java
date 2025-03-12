package com.bridgecare.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgecare.back.models.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String email);
}
