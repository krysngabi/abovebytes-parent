package com.abovebytes.dtos.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateUserReviewDTO(
        @NotNull(message = "reviewer.id.required")
        @Min(value = 1, message = "reviewer.id.must.be.greater.than.zero")
        Long reviewerId,

        @NotNull(message = "reviewee.id.required")
        @Min(value = 1, message = "reviewee.id.must.be.greater.than.zero")
        Long revieweeId,

        @NotNull(message = "rating.is.required")
        @Min(value = 1, message = "rating.must.be.at.least.1")
        @Max(value = 5, message = "rating.must.be.at.most.5")
        Double rating,
        String comment) {
}
