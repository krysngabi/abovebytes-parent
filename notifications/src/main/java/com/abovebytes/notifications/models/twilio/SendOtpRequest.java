package com.abovebytes.notifications.models.twilio;

import com.abovebytes.notifications.enums.AllowedApps;
import com.abovebytes.notifications.enums.OtpChannel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SendOtpRequest(
        @NotBlank(message = "recipient.required")
        String recipient,

        @NotNull(message = "channel.required")
        OtpChannel channel,

        @NotNull(message = "app.name.required")
        AllowedApps appName,

        String deviceId,

        @NotNull(message = "internal.user.id.required")
        Long internalUserId

) {

    public String normalizedTo() {

        if (recipient == null || recipient.isBlank()) {
            return recipient;
        }

        if (channel == OtpChannel.email) {
            return recipient;
        }

        if (!recipient.startsWith("+")) {
            return "+" + recipient;
        }

        return recipient;
    }

    public String normalizedChannel() {
        return channel.name().toLowerCase();
    }

    @Override
    public String toString() {
        return "VerifyOtpRequest {" +
                " appName='" + appName + '\'' +
                " channel='" + channel + '\'' +
                " recipient ='" + recipient + '\'' +
                " deviceId ='" + deviceId + '\'' +
                '}';
    }
}

