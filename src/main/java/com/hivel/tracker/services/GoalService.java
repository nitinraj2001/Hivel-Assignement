package com.hivel.tracker.services;

import com.hivel.tracker.dto.GoalRequest;
import com.hivel.tracker.model.Goal;
import org.springframework.stereotype.Service;

@Service
public interface GoalService {
    Goal createGoal(GoalRequest goalRequest);
}
