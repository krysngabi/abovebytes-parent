package com.abovebytes.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PasswordUpdateRequest(
        @NotBlank(message = "password.required")
        @Size(min = 5, message = "password.at.least.5.chars")
        @Size(max = 99, message = "password.max.99.chars")
        String currentPassword,

        @NotBlank(message = "new.password.required")
        @Size(min = 5, message = "new.password.at.least.5.chars")
        @Size(max = 99, message = "new.password.max.99.chars")
        String newPassword,

        @NotBlank(message = "confirm.password.required")
        @Size(min = 5, message = "confirm.password.at.least.5.chars")
        @Size(max = 99, message = "confirm.password.max.99.chars")
        String confirmPassword,
        @NotBlank(message = "phone.required")
        @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "invalid.phone")
        String phone,

        boolean isPasswordResetFromInvite,
        boolean shouldSkipHabitationCheck
) {
    @Override
    public String toString() {
        return "PasswordUpdateRequest {" +
                " phone='" + phone + '\'' +
                " isPasswordResetFromInvite='" + isPasswordResetFromInvite + '\'' +
                " shouldSkipHabitationCheck='" + shouldSkipHabitationCheck + '\'' +
                '}';
    }
}
