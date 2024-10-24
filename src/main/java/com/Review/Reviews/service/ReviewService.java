package com.Review.Reviews.service;

import com.Review.Reviews.model.Reviews;
import com.Review.Reviews.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Reviews> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Map<String, Object> getProductWithHighestAverageRating() {
        List<Reviews> reviews = reviewRepository.findAll();  // Fetch all reviews
        Map<Long, Double> productRatings = new HashMap<>(); // To store productId and their total ratings
        Map<Long, Integer> productCounts = new HashMap<>(); // To store productId and their rating count

        // Calculate total ratings and count for each productId
        for (Reviews review : reviews) {
            Long productId = review.getProductId();
            int rating = review.getRating();

            // Update total ratings
            productRatings.put(productId, productRatings.getOrDefault(productId, 0.0) + rating);

            // Update count of ratings
            productCounts.put(productId, productCounts.getOrDefault(productId, 0) + 1);
        }

        // Calculate average ratings and find the product with the highest average
        Long highestRatedProductId = null;
        double highestAverageRating = 0.0;

        for (Long productId : productRatings.keySet()) {
            double averageRating = productRatings.get(productId) / productCounts.get(productId);

            if (averageRating > highestAverageRating) {
                highestAverageRating = averageRating;
                highestRatedProductId = productId;
            }
        }

        // Prepare the response
        Map<String, Object> response = new HashMap<>();
        if (highestRatedProductId != null) {
            // Include the number of total ratings in parentheses
            int totalRatings = productCounts.get(highestRatedProductId);
            response.put("productId", highestRatedProductId);
            response.put("averageRating", String.format("%.2f (%d)", highestAverageRating, totalRatings)); // Format average rating to 2 decimal places
        } else {
            response.put("message", "No reviews available");
        }

        return response;  // Return the response
    }



}
