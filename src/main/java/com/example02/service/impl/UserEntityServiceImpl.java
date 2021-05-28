package com.example02.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example02.model.UserEntity;
import com.example02.model.UserResponse;
import com.example02.model.UserRole;
import com.example02.repository.UserEntityRepository;
import com.example02.service.UserEntityService;
import com.example02.util.UserConverter;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private UserEntityRepository repository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserResponse saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(Stream.of(UserRole.USER, UserRole.ADMIN).collect(Collectors.toSet()));

        return UserConverter.convertUserEntityToUserResponse(repository.save(userEntity));
    }

    @Override
    public List<UserResponse> getUsers() {
        return repository.findAll().stream()
                .map(UserConverter::convertUserEntityToUserResponse)
                .collect(Collectors.toList());
    }
}
