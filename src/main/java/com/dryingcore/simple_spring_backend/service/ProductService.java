package com.dryingcore.simple_spring_backend.service;

import com.dryingcore.simple_spring_backend.model.ProductModel;
import com.dryingcore.simple_spring_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // To do!!!
//    public List<ProductModel> getAllProducts() {}
}
