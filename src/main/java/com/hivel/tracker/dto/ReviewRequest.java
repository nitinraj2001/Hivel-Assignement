package com.hivel.tracker.dto;

public class ReviewRequest {
    private Long employeeId;
    private Long cycleId;
    private int rating;
    private String reviewerNotes;

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewerNotes() {
        return reviewerNotes;
    }
}
