package com.bridgecare.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgecare.back.models.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
