package com.example02.service;

import java.util.List;

import com.example02.model.ProductEntity;
import com.example02.model.ProductResponse;

public interface ProductEntityService {

    List<ProductResponse> findAll();

    List<ProductResponse> findByName(String name);

    ProductResponse saveProduct(ProductEntity productEntity);
}
