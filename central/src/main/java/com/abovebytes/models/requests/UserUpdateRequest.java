package com.abovebytes.models.requests;

import com.abovebytes.models.statuses.UserStatus;
import jakarta.validation.constraints.NotNull;

public record UserUpdateRequest(
        @NotNull(message = "userid.required")
        Long userId,

        @NotNull(message = "user.status.required")
        UserStatus status
) {
    @Override
    public String toString() {
        return "UserUpdateRequest {" +
                " userId='" + userId + '\'' +
                " status='" + status.name() + '\'' +
                '}';
    }
}
