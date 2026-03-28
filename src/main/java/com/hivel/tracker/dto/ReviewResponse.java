package com.hivel.tracker.dto;
public class ReviewResponse {

    private int rating;
    private String notes;
    private String cycleName;

    public int getRating() {
        return rating;
    }

    public ReviewResponse(int rating, String notes, String cycleName) {
        this.rating = rating;
        this.notes = notes;
        this.cycleName = cycleName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }
}
