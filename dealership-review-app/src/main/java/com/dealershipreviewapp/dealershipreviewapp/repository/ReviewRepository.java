package com.dealershipreviewapp.dealershipreviewapp.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.dealershipreviewapp.dealershipreviewapp.entity.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Set<Review> findAll();
    Optional<Review> getReviewByDealershipId(int dealershipId);
    Set<Review> getReviewsByDealershipId(int dealershipId);

}
