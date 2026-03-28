package com.hivel.tracker.controller;

import com.hivel.tracker.dto.ReviewRequest;
import com.hivel.tracker.dto.ReviewResponse;
import com.hivel.tracker.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/reviews")
    public ResponseEntity<Void> submitReview(@RequestBody ReviewRequest request){
        reviewService.submitReview(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/employees/{id}/reviews")
    public List<ReviewResponse> getReviews(@PathVariable Long id){
        return reviewService.getReviews(id);
    }


}
