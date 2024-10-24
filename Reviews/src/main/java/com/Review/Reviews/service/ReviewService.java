package com.Review.Reviews.service;

import com.Review.Reviews.model.Reviews;
import com.Review.Reviews.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Create a new review
    public Reviews createReview(Reviews review) {
        return reviewRepository.save(review);
    }

    // Get all reviews by productId
    public List<Reviews> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    // Get a review by its ID
    public Reviews getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // Delete a review by its ID
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
