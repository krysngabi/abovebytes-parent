package com.abovebytes.models.requests;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;


public record PushNotificationRequest(
        @NotBlank(message = "notification.title.required")
        String title,

        @NotBlank(message = "message.required")
        String message,

        @Nullable
        String topic,

        @NotBlank(message = "user.token.required")
        String token,

        @Nullable
        String image,

        @Nullable
        Long habitationId,

        @Nullable
        Long userId,

        boolean allUsersNotification
) {

    public PushNotificationRequest(String title, String message, @Nullable String topic,
                                   String token, @Nullable String image,
                                   @Nullable Long habitationId, boolean allUsersNotification) {
        this(title, message, topic, token, image, habitationId, null, allUsersNotification);
    }

    public PushNotificationRequest(String title, String message, @Nullable String topic,
                                   String token, @Nullable String image,
                                   @Nullable Long habitationId, boolean allUsersNotification, Long userId) {
        this(title, message, topic, token, image, habitationId, userId, allUsersNotification);
    }

    public PushNotificationRequest withUserId(Long userId) {
        return new PushNotificationRequest(
                title, message, topic, token, image, habitationId, userId, allUsersNotification);
    }

    @Override
    public String toString() {
        return "PushNotificationRequest {" +
                " title='" + title + '\'' +
                " message='" + message + '\'' +
                " token='" + token + '\'' +
                " image='" + image + '\'' +
                " habitationId='" + habitationId + '\'' +
                " userId='" + userId + '\'' +
                '}';
    }
}