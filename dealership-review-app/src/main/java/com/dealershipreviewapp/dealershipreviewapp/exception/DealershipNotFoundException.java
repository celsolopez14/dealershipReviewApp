package com.dealershipreviewapp.dealershipreviewapp.exception;

public class DealershipNotFoundException extends RuntimeException {

    public DealershipNotFoundException(int id) {
        super("The dealership id '" + id + "' does not exist in our records");
    }

}