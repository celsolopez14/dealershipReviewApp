package com.dealershipreviewapp.dealershipreviewapp.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dealershipreviewapp.dealershipreviewapp.entity.Review;
import com.dealershipreviewapp.dealershipreviewapp.entity.User;
import com.dealershipreviewapp.dealershipreviewapp.exception.ReviewNotFoundException;
import com.dealershipreviewapp.dealershipreviewapp.repository.ReviewRepository;
import com.dealershipreviewapp.dealershipreviewapp.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {

    private ReviewRepository reviewRepository;
    private UserRepository userRepository;

    @Override
    public Set<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review createReview(Review review, Long userId) {
        User user = UserServiceImp.unwrappUser(userRepository.findById(userId), userId);
        review.setUser(user);
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(String dealership) {
        Optional<Review> optionalReview = reviewRepository.getReviewByDealership(dealership);
        return unwrappReview(optionalReview, dealership);
    }

    @Override
    public Set<Review> getReviewsByUser(Long userId) {
        return reviewRepository.getReviewsByUser(userId);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Set<Review> getReviewsByDealership(String dealership) {
        return reviewRepository.getReviewsByDealership(dealership);
    }

    public static Review unwrappReview(Optional<Review> optionalReview, String dealership) {
        if(optionalReview.isPresent()) return optionalReview.get();
        throw new ReviewNotFoundException(dealership);
    }
}
