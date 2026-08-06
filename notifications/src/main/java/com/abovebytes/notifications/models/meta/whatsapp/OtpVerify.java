package com.abovebytes.notifications.models.meta.whatsapp;


import com.abovebytes.notifications.enums.AllowedApps;
import com.abovebytes.utils.CustomUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OtpVerify(
        @NotBlank(message = "recipient.required")
        String recipient,

        @NotNull(message = "otp.code.required")
        String otpCode,

        @NotNull(message = "app.name.required")
        AllowedApps appName
) {

    public String normalizedTo() {

        if (recipient == null || recipient.isBlank()) {
            return recipient;
        }

        String value = recipient.trim();

        // if email → return as is
        if (CustomUtils.validateEmail(value)) {
            return value;
        }

        // if phone and does not start with +
        value = value.trim();

        value = value.startsWith("+")
                ? value
                : "+" + value;

        return value;
    }

    @Override
    public String toString() {
        return "OtpVerify{" +
                ", appName=" + appName +
                ", otpCode='" + otpCode + '\'' +
                ", recipient='" + normalizedTo() + '\'' +
                '}';
    }
}
