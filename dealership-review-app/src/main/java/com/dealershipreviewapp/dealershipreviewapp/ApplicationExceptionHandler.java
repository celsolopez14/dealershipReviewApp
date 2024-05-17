package com.dealershipreviewapp.dealershipreviewapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dealershipreviewapp.dealershipreviewapp.exception.EntityNotFoundException;
import com.dealershipreviewapp.dealershipreviewapp.exception.ErrorResponse;
import com.dealershipreviewapp.dealershipreviewapp.exception.ReviewNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ReviewNotFoundException.class, EntityNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex){
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getLocalizedMessage()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

                List<String> errors = new ArrayList<>();
                for(ObjectError error : ex.getBindingResult().getAllErrors()){
                    errors.add(error.getDefaultMessage());
                }
        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }

}
