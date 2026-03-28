package com.hivel.tracker.services.impl;

import com.hivel.tracker.dto.CycleRequest;
import com.hivel.tracker.dto.CycleSummaryResponse;
import com.hivel.tracker.model.GoalStatus;
import com.hivel.tracker.model.ReviewCycle;
import com.hivel.tracker.repository.CycleRepository;
import com.hivel.tracker.repository.GoalRepository;
import com.hivel.tracker.repository.ReviewRepository;
import com.hivel.tracker.services.CycleService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CycleSummaryImpl implements CycleService {
    private final ReviewRepository reviewRepository;
    private final GoalRepository goalRepository;
    private final CycleRepository cycleRepository;

    public CycleSummaryImpl(ReviewRepository reviewRepository, GoalRepository goalRepository, CycleRepository cycleRepository) {
        this.reviewRepository = reviewRepository;
        this.goalRepository = goalRepository;
        this.cycleRepository = cycleRepository;
    }

    /**
     * This method is used to get the review cycle summary
     * @param cycleId it represents the review cycle id
     * @return it returns the review cycle summary
     */
    @Override
    public CycleSummaryResponse getCycleSummary(Long cycleId) {
        Double avgRating = reviewRepository.findAverageRating(cycleId);
        Long topEmployee = reviewRepository.findTopPerformer(cycleId, PageRequest.of(0,1))
                .stream().findFirst().orElse(null);
        Long completed = goalRepository.countByCycleIdAndStatus(cycleId, GoalStatus.COMPLETED);
        Long missed = goalRepository.countByCycleIdAndStatus(cycleId, GoalStatus.MISSED);
        return new CycleSummaryResponse(avgRating, topEmployee, completed, missed);
    }

    /**
     * This method is used to create a new cycle for an employee
     * @param request It represents the DTO instance for review cycle of an employee
     * @return it returns the instance of review cycle once it is saved in db successfully
     */
    @Override
    public ReviewCycle createCycle(CycleRequest request) {
        ReviewCycle reviewCycle = new ReviewCycle();
        reviewCycle.setName(request.getName());
        reviewCycle.setStartDate(request.getStartDate());
        reviewCycle.setEndDate(request.getEndDate());
        return cycleRepository.save(reviewCycle);
    }
}
