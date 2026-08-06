package com.abovebytes.notifications.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ForgotPasswordRequest(
        @NotBlank(message = "display.name.required")
        String userDisplayName,

        @NotBlank(message = "temp.password.required")
        String temporaryPassword,

        @NotBlank(message = "email.required")
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$", message = "invalid.email")
        String email,

        @NotBlank(message = "expiration.date.time.required")
        String expirationDateTime

) {
    @Override
    public String toString() {
        return "ForgotPasswordRequest {" +
                " userDisplayName='" + userDisplayName + '\'' +
                " email='" + email + '\'' +
                " expirationDateTime='" + expirationDateTime + '\'' +
                '}';
    }
}

