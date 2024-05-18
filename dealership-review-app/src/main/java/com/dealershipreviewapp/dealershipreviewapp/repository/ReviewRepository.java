package com.dealershipreviewapp.dealershipreviewapp.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.dealershipreviewapp.dealershipreviewapp.entity.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Set<Review> findAll();
    Optional<Review> getReviewByDealership(String dealership);
    Set<Review> getReviewsByDealership(String dealership);
    Set<Review> getReviewsByUser(Long userId);


}
