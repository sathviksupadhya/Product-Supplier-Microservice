package com.Review.Reviews.controller;

import com.Review.Reviews.model.Reviews;
import com.Review.Reviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Create a new review
    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Reviews review) {
        Reviews savedReview = reviewService.createReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }
//    @GetMapping("/{productId}")
//    public ResponseEntity<List<Reviews>> getAllReviews(@PathVariable("productId") Long productId) {
//        List<Reviews> reviews = reviewService.getAllReviews();
//        if (reviews.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(reviews, HttpStatus.OK);
//    }

    // Get all reviews for a specific product
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Reviews>> getReviewsByProductId(@PathVariable("productId") Long productId) {
        List<Reviews> reviews = reviewService.getReviewsByProductId(productId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Get a review by its ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Reviews> getReviewById(@PathVariable("id") Long id) {
//        Reviews review = reviewService.getReviewById(id);
//        if (review == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(review, HttpStatus.OK);
//    }

    // Delete a review by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


     //Endpoint to get the product with the highest average rating
     @GetMapping("/highest-average-rating")
     public ResponseEntity<Map<String, Object>> getProductWithHighestAverageRating() {
        Map<String, Object> response = reviewService.getProductWithHighestAverageRating();
            // Check if the response contains a message indicating no reviews are available
            if (response.containsKey("message")) {
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Return 404 if no reviews
            }

            return new ResponseEntity<>(response, HttpStatus.OK); // Return 200 with the product info
        }



    // Update a review by its ID
//    @PutMapping("/{id}")
//    public ResponseEntity<Reviews> updateReview(@PathVariable("id") Long id, @RequestBody Reviews updatedReview) {
//        Reviews review = reviewService.getReviewById(id);
//        if (review == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        review.setContent(updatedReview.getContent());
//        review.setRating(updatedReview.getRating());
//        Reviews updatedReviewEntity = reviewService.updateReview(review);
//        return new ResponseEntity<>(updatedReviewEntity, HttpStatus.OK);
//    }

}





