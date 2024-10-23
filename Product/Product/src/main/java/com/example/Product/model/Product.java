package com.example.Product.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message="Product name is mandatory")
    @Size(min=2,max=100,message="Product name must between 2 and 100")
    private String name;

    @Size(max=500,message="Description cannot exceed 500 characters")
    private String description;

    @NotNull(message="Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private double price;

    @Min(value=0,message="Quantity cannot be less than 0")
    private int quantity;

//    public Product(String name, String description, double price, int quantity) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.quantity = quantity;
//    }
}
