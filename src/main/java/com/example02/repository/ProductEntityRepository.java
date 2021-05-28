package com.example02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example02.model.ProductEntity;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByName(String name);
}
