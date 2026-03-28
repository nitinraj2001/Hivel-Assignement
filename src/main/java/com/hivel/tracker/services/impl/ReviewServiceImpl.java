package com.hivel.tracker.services.impl;

import com.hivel.tracker.dto.ReviewRequest;
import com.hivel.tracker.dto.ReviewResponse;
import com.hivel.tracker.model.Employee;
import com.hivel.tracker.model.PerformanceReview;
import com.hivel.tracker.model.ReviewCycle;
import com.hivel.tracker.repository.CycleRepository;
import com.hivel.tracker.repository.EmployeeRepository;
import com.hivel.tracker.repository.ReviewRepository;
import com.hivel.tracker.services.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final EmployeeRepository employeeRepository;
    private final CycleRepository cycleRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, EmployeeRepository employeeRepository, CycleRepository cycleRepository) {
        this.reviewRepository = reviewRepository;
        this.employeeRepository = employeeRepository;
        this.cycleRepository = cycleRepository;
    }

    /**
     * This method is used to submit reviews for an employee
     * @param request it represents the review request instance
     */
    @Override
    public void submitReview(ReviewRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(()-> new RuntimeException("Employee not found"));
        ReviewCycle cycle = cycleRepository.findById(request.getCycleId())
                .orElseThrow(() -> new RuntimeException("Cycle not found"));
        PerformanceReview review = new PerformanceReview();
        review.setEmployee(employee);
        review.setCycle(cycle);
        review.setReviewerNotes(request.getReviewerNotes());
        review.setSubmittedAt(LocalDateTime.now());
        review.setRating(request.getRating());
        reviewRepository.save(review);
    }

    /**
     * This method is used to fetch all reviews of an employee using the employee id
     * @param employeeId it represents the employee id of an employee
     * @return it returns all reviews of an employee if an employee is not found then returns run time exception
     */
    @Override
    public List<ReviewResponse> getReviews(Long employeeId) {

        return reviewRepository.findReviewsByEmployee(employeeId)
                .stream()
                .map(r -> new ReviewResponse(
                        r.getRating(),
                        r.getReviewerNotes(),
                        r.getCycle().getName()
                )).toList();
    }
}
