package com.dryingcore.simple_spring_backend.controller;

import com.dryingcore.simple_spring_backend.model.ProductModel;
import com.dryingcore.simple_spring_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String rootPath() {
        return "Hello, world!";
    }

    @GetMapping("/get_products")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get_products/{id}")
    public ProductModel getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add_product")
    public ProductModel addNewProduct(@RequestBody ProductModel productModel) {
        return productService.saveProductToDatabase(productModel);
    }

}
