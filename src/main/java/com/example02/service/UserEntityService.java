package com.example02.service;

import java.util.List;
import java.util.Optional;

import com.example02.model.UserEntity;
import com.example02.model.UserResponse;

public interface UserEntityService {

    Optional<UserEntity> findByUsername(String username);

    UserResponse saveUser(UserEntity userEntity);

    List<UserResponse> getUsers();
}
