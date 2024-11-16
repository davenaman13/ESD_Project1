package com.namandave.yummyapp.service;

import com.namandave.yummyapp.dto.ProductRequest;
import com.namandave.yummyapp.dto.ProductResponse;
import com.namandave.yummyapp.entity.Product;
import com.namandave.yummyapp.mapper.ProductMapper;
import com.namandave.yummyapp.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Add a product
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = ProductMapper.toEntity(productRequest);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toResponse(savedProduct);
    }

    // Get all products
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Get a product by ID
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toResponse(product);
    }

    // Update a product
    public ProductResponse updateProduct(Long id, ProductRequest updatedProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(updatedProductRequest.getName());
        product.setPrice(updatedProductRequest.getPrice());
        Product updatedProduct = productRepository.save(product);
        return ProductMapper.toResponse(updatedProduct);
    }

    // Delete a product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
