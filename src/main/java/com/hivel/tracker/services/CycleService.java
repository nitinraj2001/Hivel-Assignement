package com.hivel.tracker.services;

import com.hivel.tracker.dto.CycleRequest;
import com.hivel.tracker.dto.CycleSummaryResponse;
import com.hivel.tracker.model.ReviewCycle;
import org.springframework.stereotype.Service;

@Service
public interface CycleService {
    CycleSummaryResponse getCycleSummary(Long cycleId);
    ReviewCycle createCycle(CycleRequest request);
}
