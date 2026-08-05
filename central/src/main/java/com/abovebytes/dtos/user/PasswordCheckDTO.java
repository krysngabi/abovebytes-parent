package com.abovebytes.dtos.user;

import java.time.LocalDateTime;

public record PasswordCheckDTO(
        boolean expired,
        boolean warn,
        long daysLeft,
        int expiryDays,
        LocalDateTime expiredDate
) {
}
