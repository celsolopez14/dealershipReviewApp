package com.dealershipreviewapp.dealershipreviewapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dealershipreviewapp.dealershipreviewapp.entity.Dealership;
import com.dealershipreviewapp.dealershipreviewapp.service.DealershipService;

import lombok.AllArgsConstructor;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/dealerships")
public class DealershipController {

    DealershipService dealershipService;

    @GetMapping("/")
    public ResponseEntity<Set<Dealership>> getDealerships() {
        Set<Dealership> allDealerships = dealershipService.getAllDealerships();
        return new ResponseEntity<>(allDealerships, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dealership> getDealership(@PathVariable int id) {
        Dealership dealership = dealershipService.getDealership(id);
        return new ResponseEntity<>(dealership, HttpStatus.OK);
    }

}
