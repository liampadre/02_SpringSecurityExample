package com.example02.util;

import java.util.stream.Collectors;

import com.example02.model.UserEntity;
import com.example02.model.UserRequest;
import com.example02.model.UserResponse;

public class UserConverter {

    public static UserResponse convertUserEntityToUserResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .username(userEntity.getUsername())
                .avatar(userEntity.getAvatar())
                .roles(userEntity.getAuthorities().stream().map(ga -> ga.getAuthority()).collect(Collectors.toSet()))
                .build();
    }

    public static UserEntity convertUserRequestToUserEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .avatar(userRequest.getAvatar())
                .password(userRequest.getPassword())
                .build();
    }
}
