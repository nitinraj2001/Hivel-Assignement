package com.hivel.tracker.dto;

public class GoalResponse {
    private Long id;
    private String title;
    private String status;
    private Long employeeId;
    private Long cycleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public GoalResponse(Long id, String title, String status, Long employeeId, Long cycleId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.employeeId = employeeId;
        this.cycleId = cycleId;
    }
}
