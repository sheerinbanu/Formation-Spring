package com.formation.spring.exceptions;


public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(){

        super("Book not found", new Throwable("Book not found"));
    }


}
