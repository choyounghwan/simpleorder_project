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

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    
    private final ProductService productService;

    //상품 등록
    @PostMapping("/admin/register_product")
    public String registerProduct(@RequestBody ProductInDto product) {
        productService.createProduct(product);
        return "상품이 등록되었습니다.";
    }

    //상품 다건 조회
    @GetMapping("/product_list")
    public List<ProductOutDto> getProductList() {
        return productService.selectAllproducts();
    }
    
    //상품 단건 조회
    @GetMapping("/product_list/{id}")
    public ProductOutDto getProductById(@PathVariable("id") Long id) {
        return productService.selectProductById(id);
    }

    //상품 삭제
    @DeleteMapping("/admin/delete_product/{id}")
    public String removeProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "상품이 삭제되었습니다.";
    }
}
