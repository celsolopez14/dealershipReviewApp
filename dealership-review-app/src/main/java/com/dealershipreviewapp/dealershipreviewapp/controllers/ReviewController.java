package com.dealershipreviewapp.dealershipreviewapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dealershipreviewapp.dealershipreviewapp.entity.Review;
import com.dealershipreviewapp.dealershipreviewapp.entity.User;
import com.dealershipreviewapp.dealershipreviewapp.security.SecurityConstants;
import com.dealershipreviewapp.dealershipreviewapp.service.ReviewService;
import com.dealershipreviewapp.dealershipreviewapp.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;
    private UserService userService;
    
    @GetMapping("/all")
    public ResponseEntity<Set<Review>> getReviews() {
        Set<Review> allReviews = reviewService.getAllReviews();
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    @PostMapping("user/{userId}")
    public ResponseEntity<Review> createReview(@Valid @RequestBody Review review, @PathVariable Long userId) {
        return new ResponseEntity<>(reviewService.createReview(review, userId), HttpStatus.CREATED);
    }

    @GetMapping("user/{userId}/all")
    public ResponseEntity<Set<Review>> getReviewsFromUser(@PathVariable Long userId) {
        return new ResponseEntity<>(reviewService.getReviewsByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/dealership/{dealershipId}/all")
    public ResponseEntity<Set<Review>> getReviewsFromDealership(@PathVariable String dealership) {
        return new ResponseEntity<>(reviewService.getReviewsByDealership(dealership), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken) {
        String token = bearerToken.replace(SecurityConstants.BEARER, "");
        String username = JWT.require(Algorithm.HMAC512(
                SecurityConstants.SECRET))
                .build()
                .verify(token)
                .getSubject();
        User user = userService.getUser(username);
        Review review = reviewService.getReview(id);

        if(review.getUser() != user) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
