package com.bridgecare.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgecare.common.models.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String email);
}
