package com.simpleorder.dto.product;

import java.math.BigDecimal;

import com.simpleorder.entity.product.Product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductOutDto {
    private String productname;
    private BigDecimal price;

    public static ProductOutDto toDto(Product entity) {
        return ProductOutDto.builder()
        .productname(entity.getProductname())
        .price(entity.getPrice())
        .build();
    }
}
