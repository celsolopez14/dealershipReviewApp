package com.dealershipreviewapp.dealershipreviewapp.exception;

public class ReviewNotFoundException extends RuntimeException {
    
    public ReviewNotFoundException(int dealershipId) {
        super("The dealership id '" + dealershipId + "' does not contains any review in our records");
    }
}
