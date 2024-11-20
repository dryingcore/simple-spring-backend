package com.dryingcore.simple_spring_backend.service;

import com.dryingcore.simple_spring_backend.entity.ProductEntity;
import com.dryingcore.simple_spring_backend.model.ProductModel;
import com.dryingcore.simple_spring_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll().stream().map(ProductModel::fromEntity).collect(Collectors.toList());
    }

    public ProductModel getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "Product Not Found with ID: " + id));
        return ProductModel.fromEntity(productEntity);
    }

    public ProductModel saveProductToDatabase(ProductModel productModel) {
        ProductEntity productEntity = productModel.toEntity();
        ProductEntity savedEntity = productRepository.save(productEntity);
        return ProductModel.fromEntity(savedEntity);
    }

    public void deleteProductById(long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }
}
