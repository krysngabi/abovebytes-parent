package com.abovebytes.models.requests;

import jakarta.validation.constraints.NotBlank;

public record ChibiSafeLoginRequest(
        @NotBlank(message = "username.required")
        String username,

        @NotBlank(message = "password.required")
        String password
) {
    @Override
    public String toString() {
        return "ChibiSafeLoginRequest {" +
                " username='" + username + '\'' +
                '}';
    }
}
