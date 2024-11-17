package com.dryingcore.simple_spring_backend.model;

import lombok.*;

/**
 * Represents a product with a name and price.
 * Ensures that the product name is not null or empty and that the price is not negative.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductModel {
    private Long id;
    private String productName;
    private Double price;

    /**
     * Validates the price to ensure it's not null or negative.
     *
     * @param price The price of the product.
     * @throws IllegalArgumentException If the price is null or negative.
     */
    public void ensureValidPrice(Double price) {
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Price cannot be negative or null");
        }
    }

    /**
     * Validates the product name to ensure it's not null or empty.
     *
     * @param productName The name of the product.
     * @throws IllegalArgumentException If the product name is null or empty.
     */
    public void ensureValidName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product Name cannot be null or empty");
        }
    }

    /**
     * Sets the price for the product, ensuring it is valid.
     *
     * @param price The price of the product.
     */
    public void setPrice(Double price) {
        ensureValidPrice(price);
        this.price = price;
    }

    /**
     * Sets the product name, ensuring it is valid.
     *
     * @param productName The name of the product.
     */
    public void setProductName(String productName) {
        ensureValidName(productName);
        this.productName = productName;
    }

    /**
     * Constructs a ProductModel instance, validating product name and price.
     *
     * @param id The ID of the product (can be set automatically).
     * @param productName The name of the product.
     * @param price The price of the product.
     */
    public ProductModel(Long id, String productName, Double price) {
        this.id = id;
        setProductName(productName);
        setPrice(price);
    }
}
