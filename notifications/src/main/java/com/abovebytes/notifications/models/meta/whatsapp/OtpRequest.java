package com.abovebytes.notifications.models.meta.whatsapp;

import com.abovebytes.notifications.enums.AllowedApps;
import com.abovebytes.notifications.enums.CodeDeliverySetUp;
import com.abovebytes.utils.CustomUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OtpRequest(
        @NotBlank(message = "recipient.required")
        String recipient,

        @NotNull(message = "user.id.required")
        Long userId,

        int codeLength,

        @NotNull(message = "purpose.required")
        String purpose,

        @NotNull(message = "support.phone.required")
        String supportPhone,

        @NotNull(message = "app.name.required")
        AllowedApps appName,

        @NotNull(message = "code.delivery.required")
        CodeDeliverySetUp codeDeliverySetUp
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
        return "OtpRequest{" +
                "recipient='" + normalizedTo() + '\'' +
                ", userId=" + userId +
                ", codeLength=" + codeLength +
                ", purpose='" + purpose + '\'' +
                ", supportPhone='" + supportPhone + '\'' +
                ", appName=" + appName +
                ", codeDeliverySetUp=" + codeDeliverySetUp +
                '}';
    }
}
