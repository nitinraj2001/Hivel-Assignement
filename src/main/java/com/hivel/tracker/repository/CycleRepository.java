package com.hivel.tracker.repository;

import com.hivel.tracker.model.ReviewCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleRepository extends JpaRepository<ReviewCycle, Long> {
}
