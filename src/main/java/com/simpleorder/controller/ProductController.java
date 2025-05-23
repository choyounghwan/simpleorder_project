package com.simpleorder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleorder.dto.product.ProductInDto;
import com.simpleorder.dto.product.ProductOutDto;
import com.simpleorder.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    
    private final ProductService productService;

    @PostMapping("/admin/register_product")
    public String registerProduct(@RequestBody ProductInDto product) {
        productService.createProduct(product);
        return "상품이 등록되었습니다.";
    }

    @GetMapping("/product_list")
    public List<ProductOutDto> getProductList() {
        return productService.selectAllproducts();
    }
    
    @GetMapping("/product_list/{id}")
    public ProductOutDto getProductById(@PathVariable("id") Long id) {
        return productService.selectProductById(id);
    }

}
