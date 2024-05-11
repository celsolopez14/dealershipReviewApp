package com.dealershipreviewapp.dealershipreviewapp.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.dealershipreviewapp.dealershipreviewapp.entity.Dealership;

public interface DealershipRepository extends CrudRepository<Dealership, Integer> {
    Set<Dealership> findAll();
    
}
