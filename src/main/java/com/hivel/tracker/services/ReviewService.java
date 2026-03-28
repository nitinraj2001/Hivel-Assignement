package com.hivel.tracker.services;

import com.hivel.tracker.dto.ReviewRequest;
import com.hivel.tracker.dto.ReviewResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    void submitReview(ReviewRequest request);
    List<ReviewResponse> getReviews(Long employeeId);
}
