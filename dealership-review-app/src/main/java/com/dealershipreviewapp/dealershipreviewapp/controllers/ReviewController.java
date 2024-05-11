package com.dealershipreviewapp.dealershipreviewapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealershipreviewapp.dealershipreviewapp.entity.Review;
import com.dealershipreviewapp.dealershipreviewapp.service.ReviewService;

import lombok.AllArgsConstructor;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    ReviewService reviewService;
    @GetMapping("/")
    public ResponseEntity<Set<Review>> getReviews() {
        Set<Review> allReviews = reviewService.getAllReviews();
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    @PostMapping("/review/{dealershipId}")
    public ResponseEntity<Review> createReview(@RequestBody Review review, @PathVariable int dealershipId) {
        return new ResponseEntity<>(reviewService.createReview(review, dealershipId), HttpStatus.CREATED);
    }

    @GetMapping("/dealership/{dealershipId}")
    public ResponseEntity<Set<Review>> getReviewsFromDealership(@PathVariable int dealershipId) {
        return new ResponseEntity<>(reviewService.getReviewsByDealershipId(dealershipId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
