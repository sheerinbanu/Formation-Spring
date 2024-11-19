package com.formation.spring.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Book not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({NegativePriceException.class})
    protected ResponseEntity<Object> handleNegativePrice(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Negative price not allowed", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ReviewNotFoundException.class})
    protected ResponseEntity<Object> handleReviewNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "review not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ReviewNotFoundException.class})
    protected ResponseEntity<Object> handleProductNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Product not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ReviewNotFoundException.class})
    protected ResponseEntity<Object> handleCartNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Cart not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    
}
