package com.simpleorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleorder.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    boolean existsByProductname(String productname);
} 