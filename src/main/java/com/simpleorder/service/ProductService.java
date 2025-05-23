package com.simpleorder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simpleorder.dto.product.ProductInDto;
import com.simpleorder.dto.product.ProductOutDto;
import com.simpleorder.entity.product.Product;
import com.simpleorder.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public void createProduct(ProductInDto productInDto) {
        if(productRepository.existsByProductname(productInDto.getProductname())) {
            throw new IllegalArgumentException("이미 존재하는 상품입니다.");
        }
        Product product = ProductInDto.toEntity(productInDto);
        productRepository.save(product);
    }

    public List<ProductOutDto> selectAllproducts() {
        List<Product> products = productRepository.findAll();
        List<ProductOutDto> productOutDtos = new ArrayList<>();
        for(Product product : products) {
            ProductOutDto dto = ProductOutDto.toDto(product);
            productOutDtos.add(dto);
        }
        return productOutDtos;
    }

    public ProductOutDto selectProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. ID: " + id));

        return ProductOutDto.toDto(product);
    }
}
