package com.formation.spring.exceptions;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException() {
        super("Cart not found", new Throwable("cart not found"));
    }
}
