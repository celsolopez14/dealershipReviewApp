package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Set;

import com.dealershipreviewapp.dealershipreviewapp.entity.Review;

public interface ReviewService {
    Set<Review> getAllReviews();
    Set<Review> getReviewsByDealership(String dealership);
    Review getReview(String dealership);
    Review createReview(Review review, Long userId);
    void deleteReview(Long id);
}
