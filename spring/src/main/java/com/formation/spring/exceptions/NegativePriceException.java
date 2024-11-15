package com.formation.spring.exceptions;


public class NegativePriceException extends RuntimeException {

    public NegativePriceException(){

        super("Negative price", new Throwable("Negative price"));
    }


}
