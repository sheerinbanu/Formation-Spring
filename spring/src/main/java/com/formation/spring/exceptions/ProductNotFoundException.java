package com.formation.spring.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {

        super("Product not found", new Throwable("product not found"));
    }
}
