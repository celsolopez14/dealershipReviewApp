package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dealershipreviewapp.dealershipreviewapp.entity.Dealership;
import com.dealershipreviewapp.dealershipreviewapp.entity.Review;
import com.dealershipreviewapp.dealershipreviewapp.exception.ReviewNotFoundException;
import com.dealershipreviewapp.dealershipreviewapp.repository.DealershipRepository;
import com.dealershipreviewapp.dealershipreviewapp.repository.ReviewRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {

    ReviewRepository reviewRepository;
    DealershipRepository dealershipRepository;

    @Override
    public Set<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review createReview(Review review, int dealershipId) {
        Optional<Dealership> optionalDealership = dealershipRepository.findById(dealershipId);
        Dealership unwrappedDealership = DealershipServiceImp.unwrappDealership(optionalDealership, dealershipId);
        review.setDealership(unwrappedDealership);
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(int dealershipId) {
        Optional<Review> optionalReview = reviewRepository.getReviewByDealershipId(dealershipId);
        return unwrappReview(optionalReview, dealershipId);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Set<Review> getReviewsByDealershipId(int dealershipId) {
        return reviewRepository.getReviewsByDealershipId(dealershipId);
    }

    public static Review unwrappReview(Optional<Review> optionalReview, int id) {
        if(optionalReview.isPresent()) return optionalReview.get();
        throw new ReviewNotFoundException(id);
    }
}
