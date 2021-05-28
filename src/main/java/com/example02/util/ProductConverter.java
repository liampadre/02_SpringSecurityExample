package com.example02.util;

import java.util.stream.Collectors;

import com.example02.model.ProductEntity;
import com.example02.model.ProductRequest;
import com.example02.model.ProductResponse;
import com.example02.model.UserEntity;
import com.example02.model.UserRequest;
import com.example02.model.UserResponse;

public class ProductConverter {

    public static ProductResponse convertProductEntityToProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .build();
    }

    public static ProductEntity convertUserRequestToUserEntity(ProductRequest productRequest) {
        return ProductEntity.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }
}
