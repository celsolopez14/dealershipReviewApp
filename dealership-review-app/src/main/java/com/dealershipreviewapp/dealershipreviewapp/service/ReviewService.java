package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Set;

import com.dealershipreviewapp.dealershipreviewapp.entity.Review;

public interface ReviewService {
    Set<Review> getAllReviews();
    Set<Review> getReviewsByDealership(String dealership);
    Set<Review> getReviewsByUser(Long userId);
    Review getReview(String dealership);
    Review getReview(Long id);
    Review createReview(Review review, Long userId);
    void deleteReview(Long id);
}
