package com.hivel.tracker.dto;

public class GoalRequest {
    private Long employeeId;
    private Long cycleId;
    private String status;
    private String title;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GoalRequest(Long employeeId, Long cycleId, String status, String title) {
        this.employeeId = employeeId;
        this.cycleId = cycleId;
        this.status = status;
        this.title = title;
    }
}
