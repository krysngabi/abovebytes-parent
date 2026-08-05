package com.abovebytes.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ForgotPasswordRequest(
        @NotBlank(message = "phone.required")
        @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "invalid.phone")
        String phone,

        @NotBlank(message = "lastname.required")
        String lastname,

        @NotBlank(message = "email.required")
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$", message = "invalid.email")
        String email,

        @NotBlank(message = "friendly.name.required")
        String friendlyName,

        @NotBlank(message = "dob.required")
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "invalid.dob")
        String dateOfBirth

) {
    @Override
    public String toString() {
        return "ForgotPasswordRequest {" +
                " phone='" + phone + '\'' +
                " email='" + email + '\'' +
                " friendlyName='" + friendlyName + '\'' +
                " dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
