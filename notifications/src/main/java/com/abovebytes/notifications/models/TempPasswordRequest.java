package com.abovebytes.notifications.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TempPasswordRequest(
        @NotBlank(message = "display.name.required")
        String userDisplayName,

        @NotBlank(message = "temp.password.required")
        String temporaryPassword,

        @NotBlank(message = "phone.required")
        String userPhone,

        @NotBlank(message = "email.required")
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$", message = "invalid.email")
        String email

) {
    @Override
    public String toString() {
        return "TempPasswordRequest {" +
                " userDisplayName='" + userDisplayName + '\'' +
                " email='" + email + '\'' +
                " userPhone='" + userPhone + '\'' +
                '}';
    }
}

