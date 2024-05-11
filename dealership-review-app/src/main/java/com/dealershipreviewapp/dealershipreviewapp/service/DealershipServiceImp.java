package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dealershipreviewapp.dealershipreviewapp.entity.Dealership;
import com.dealershipreviewapp.dealershipreviewapp.exception.DealershipNotFoundException;
import com.dealershipreviewapp.dealershipreviewapp.repository.DealershipRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class DealershipServiceImp implements DealershipService {

    DealershipRepository dealershipRepository;
    @Override
    public Dealership getDealership(int id) {
        Optional<Dealership> optionalDealership = dealershipRepository.findById(id);
        return unwrappDealership(optionalDealership, id);
    }

    @Override
    public Set<Dealership> getAllDealerships() {
        return dealershipRepository.findAll();
    }

    public static Dealership unwrappDealership(Optional<Dealership> optionalDealership, int id) {
        if(optionalDealership.isPresent()) return optionalDealership.get();
        throw new DealershipNotFoundException(id);
    }

}
