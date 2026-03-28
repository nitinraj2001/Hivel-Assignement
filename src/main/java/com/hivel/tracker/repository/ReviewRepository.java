package com.hivel.tracker.repository;

import com.hivel.tracker.model.PerformanceReview;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<PerformanceReview, Long> {

    @Query("""
            SELECT r FROM PerformanceReview r
            JOIN FETCH r.cycle
            WHERE r.employee.id=:employeeId
            """)
    List<PerformanceReview> findReviewsByEmployee(Long employeeId);

    @Query("""
            SELECT AVG(r.rating) 
            FROM PerformanceReview r
            WHERE r.cycle.id=:cycleId
            """)
    Double findAverageRating(Long cycleId);

    @Query("""
            SELECT r.employee.id
            FROM PerformanceReview r
            WHERE r.cycle.id=:cycleId
            GROUP BY r.employee.id
            ORDER BY AVG(r.rating) DESC
           """)
    List<Long> findTopPerformer(Long cycleId, Pageable pageable);
}
