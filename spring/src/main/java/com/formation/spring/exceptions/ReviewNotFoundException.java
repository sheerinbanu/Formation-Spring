package com.formation.spring.exceptions;

public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException() {

        super("Review not found", new Throwable("Book not found"));
    }
}
