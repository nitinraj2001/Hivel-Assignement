package com.hivel.tracker.model;

import jakarta.persistence.*;
@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cycle_id")
    private ReviewCycle cycle;

    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GoalStatus status;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GoalStatus getStatus() {
        return status;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }

    public Goal(Employee employee, ReviewCycle cycle, String title, GoalStatus status) {
        this.employee = employee;
        this.cycle = cycle;
        this.title = title;
        this.status = status;
    }

    public Goal() {
    }
}
