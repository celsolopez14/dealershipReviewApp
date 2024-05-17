package com.dealershipreviewapp.dealershipreviewapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealershipreviewapp.dealershipreviewapp.dtos.UserDTO;
import com.dealershipreviewapp.dealershipreviewapp.entity.User;
import com.dealershipreviewapp.dealershipreviewapp.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @RequestMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
    
}
