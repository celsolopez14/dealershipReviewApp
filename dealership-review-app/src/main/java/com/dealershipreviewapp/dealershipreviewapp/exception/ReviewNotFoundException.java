package com.dealershipreviewapp.dealershipreviewapp.exception;

public class ReviewNotFoundException extends RuntimeException {
    
    public ReviewNotFoundException(String dealership) {
        super("The dealership: '" + dealership + "' does not contains any review in our records");
    }
}
