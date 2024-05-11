package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Set;

import com.dealershipreviewapp.dealershipreviewapp.entity.Review;

public interface ReviewService {
    Set<Review> getAllReviews();
    Set<Review> getReviewsByDealershipId(int dealershipId);
    Review getReview(int dealershipId);
    Review createReview(Review review, int dealershipId);
    void deleteReview(Long id);
}
