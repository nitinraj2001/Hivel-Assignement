package com.hivel.tracker.dto;

import java.time.LocalDate;

public class EmployeeRequest {

    private String name;
    private String department;
    private String role;
    private LocalDate joiningDate;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }
}
