package com.abovebytes.dtos.penalty;

import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

public record PenaltyCreationRequest(
        @NotNull(message = "penalties.required")
        List<PenaltyDTO> penalties

) {
    @Override
    public String toString() {
        return "PenaltyCreationRequest{" +
                ", penalties=" + (penalties.isEmpty() ? "No penalties provided" : Arrays.toString(penalties.toArray())) +
                '}';
    }
}
