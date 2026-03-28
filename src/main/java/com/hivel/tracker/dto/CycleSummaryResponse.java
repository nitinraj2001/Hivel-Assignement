package com.hivel.tracker.dto;

import lombok.*;

@Getter
@Setter
public class CycleSummaryResponse {
    private Double averageRating;
    private Long topPerformerEmployeeId;
    private Long completedGoals;
    private Long missedGoals;

    public CycleSummaryResponse(Double averageRating, Long topPerformerEmployeeId, Long completedGoals, Long missedGoals) {
        this.averageRating = averageRating;
        this.topPerformerEmployeeId = topPerformerEmployeeId;
        this.completedGoals = completedGoals;
        this.missedGoals = missedGoals;
    }
}
