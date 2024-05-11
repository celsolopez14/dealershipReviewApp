package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Set;

import com.dealershipreviewapp.dealershipreviewapp.entity.Dealership;
public interface DealershipService {
    Dealership getDealership(int id);
    Set<Dealership> getAllDealerships();

}
