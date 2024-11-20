package com.dryingcore.simple_spring_backend.model;

import com.dryingcore.simple_spring_backend.entity.ProductEntity;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Represents a product with a name and price.
 * Ensures that the product name is not null or empty and that the price is not negative.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductModel {

    @NotNull(message = "Product name cannot be null")
    @NotEmpty(message = "Product name cannot be empty")
    private String productName;

    @NotNull(message ="Price cannot be null")
    @PositiveOrZero(message = "Price cannot be negative")
    private Double price;

    /**
    * Constructs a ProductModel from an entity
    *
    * @param productEntity The entity which will originate a new model
    * @return A model created from an entity
     */
    public static ProductModel fromEntity(ProductEntity productEntity) {
        return new ProductModel(
                productEntity.getProductName(),
                productEntity.getPrice());
    }

    /**
     * Create a new Entity based on a model
     *
     * @return An entity created from a ProductModel
     */
    public ProductEntity toEntity() {
        final ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productName);
        productEntity.setPrice(price);
        return productEntity;
    }
}
