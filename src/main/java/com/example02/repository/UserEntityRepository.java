package com.example02.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example02.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
