package com.abovebytes.models.requests;

import jakarta.validation.constraints.NotNull;

public record PushTokenUpdate(
        @NotNull(message = "phone.required")
        String phone,

        @NotNull(message = "user.token.required")
        String pushToken
) {
    @Override
    public String toString() {
        return "PushTokenUpdate {" +
                "phone='" + phone + '\'' +
                ", pushToken='" + pushToken.substring(0, Math.min(15, pushToken.length())) + "..." + '\'' +
                '}';
    }
}
