package com.hivel.tracker.controller;

import com.hivel.tracker.dto.CycleRequest;
import com.hivel.tracker.dto.CycleSummaryResponse;
import com.hivel.tracker.model.ReviewCycle;
import com.hivel.tracker.services.CycleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CycleController {
    private final CycleService cycleService;

    public CycleController(CycleService cycleService) {
        this.cycleService = cycleService;
    }

    @GetMapping("/cycles/{id}/summary")
    public CycleSummaryResponse getSummary(@PathVariable Long id){
        return cycleService.getCycleSummary(id);
    }

    @PostMapping("/cycles")
    public ResponseEntity<ReviewCycle> createCycle(@RequestBody CycleRequest cycleRequest){
        ReviewCycle reviewCycle = cycleService.createCycle(cycleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewCycle);
    }
}
