package com.hivel.tracker.repository;

import com.hivel.tracker.model.Goal;
import com.hivel.tracker.model.GoalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    Long countByCycleIdAndStatus(Long cycleId, GoalStatus status);
}
