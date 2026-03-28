package com.hivel.tracker.services.impl;

import com.hivel.tracker.dto.GoalRequest;
import com.hivel.tracker.model.Employee;
import com.hivel.tracker.model.Goal;
import com.hivel.tracker.model.GoalStatus;
import com.hivel.tracker.model.ReviewCycle;
import com.hivel.tracker.repository.CycleRepository;
import com.hivel.tracker.repository.EmployeeRepository;
import com.hivel.tracker.repository.GoalRepository;
import com.hivel.tracker.services.GoalService;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    private final EmployeeRepository employeeRepository;
    private final CycleRepository cycleRepository;

    public GoalServiceImpl(GoalRepository goalRepository, EmployeeRepository employeeRepository, CycleRepository cycleRepository) {
        this.goalRepository = goalRepository;
        this.employeeRepository = employeeRepository;
        this.cycleRepository = cycleRepository;
    }

    /**
     * This method is used to create new goals
     * @param goalRequest it represents the goal request instance
     * @return returns the instance of save goal request
     */
    @Override
    public Goal createGoal(GoalRequest goalRequest) {
        Employee employee = employeeRepository.findById(goalRequest.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        ReviewCycle reviewCycle = cycleRepository.findById(goalRequest.getCycleId())
                .orElseThrow(()-> new RuntimeException("Cycle not found"));
        Goal goal = new Goal();
        goal.setCycle(reviewCycle);
        goal.setEmployee(employee);
        goal.setStatus(GoalStatus.valueOf(goalRequest.getStatus()));
        goal.setTitle(goalRequest.getTitle());
        return goalRepository.save(goal);
    }
}
