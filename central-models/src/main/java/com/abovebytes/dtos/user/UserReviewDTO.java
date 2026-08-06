package com.abovebytes.dtos.user;

import java.time.LocalDateTime;

public record UserReviewDTO(
        Long reviewerId,
        String reviewerName,
        Double rating,
        String comment,
        LocalDateTime createDate
) {
}
