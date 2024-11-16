package com.namandave.yummyapp.mapper;

import com.namandave.yummyapp.dto.ProductRequest;
import com.namandave.yummyapp.dto.ProductResponse;
import com.namandave.yummyapp.entity.Product;

public class ProductMapper {
    // Convert ProductRequest to Product entity
    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }

    // Convert Product entity to ProductResponse DTO
    public static ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        return response;
    }
}
