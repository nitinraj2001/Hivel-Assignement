package com.hivel.tracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class PerformanceReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    private ReviewCycle cycle;
    private int rating;
    private String reviewerNotes;
    private LocalDateTime submittedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ReviewCycle getCycle() {
        return cycle;
    }

    public void setCycle(ReviewCycle cycle) {
        this.cycle = cycle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewerNotes() {
        return reviewerNotes;
    }

    public void setReviewerNotes(String reviewerNotes) {
        this.reviewerNotes = reviewerNotes;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public PerformanceReview() {
    }

    public PerformanceReview(Employee employee, ReviewCycle cycle, int rating, String reviewerNotes, LocalDateTime submittedAt) {
        this.employee = employee;
        this.cycle = cycle;
        this.rating = rating;
        this.reviewerNotes = reviewerNotes;
        this.submittedAt = submittedAt;
    }
}
