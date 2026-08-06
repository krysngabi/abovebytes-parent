package com.abovebytes.notifications.models.twilio;

import com.abovebytes.utils.CustomUtils;
import jakarta.validation.constraints.NotBlank;

public record ValidateOtpRequest(
        @NotBlank(message = "to.required")
        String to,

        @NotBlank(message = "otp.code.required")
        String code,

        @NotBlank(message = "app.name.required")
        String appName

) {

    public String normalizedTo() {

        if (to == null || to.isBlank()) {
            return to;
        }

        String value = to.trim();

        // if email → return as is
        if (CustomUtils.validateEmail(value)) {
            return value;
        }

        // if phone and does not start with +
        if (!value.startsWith("+")) {
            return "+" + value;
        }

        return value;
    }

    @Override
    public String toString() {
        return "ValidateOtpRequest {" +
                " to='" + to + '\'' +
                " code='" + code + '\'' +
                " appName='" + appName + '\'' +
                '}';
    }
}

