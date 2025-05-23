package com.simpleorder.dto.product;

import java.math.BigDecimal;

import com.simpleorder.entity.product.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInDto {
    private String productname;
    private BigDecimal price;
    private int stock;

    public static Product toEntity(ProductInDto dto) {
        return Product.builder()
        .productname(dto.productname)
        .price(dto.price)
        .stock(dto.stock)
        .build();
    }
}
