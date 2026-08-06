package com.abovebytes.notifications.models.meta.whatsapp;

import com.abovebytes.notifications.enums.AllowedApps;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StatusRequest(
        @NotBlank(message = "to.required")
        String to,

        @NotBlank(message = "document.id.required")
        String documentId,

        @NotBlank(message = "document.name.required")
        String documentName,

        @NotBlank(message = "user.name.required")
        String userName,

        @NotBlank(message = "status.required")
        String status,

        @NotNull(message = "app.name.required")
        AllowedApps appName
) {

    public String normalizedTo() {

        if (to == null || to.isBlank()) {
            return to;
        }

        if (!to.startsWith("+")) {
            return "+" + to;
        }

        return to;
    }


    @Override
    public String toString() {
        return "StatusRequest{" +
                ", appName=" + appName +
                ", to=" + to +
                ", userName=" + userName +
                ", documentName=" + documentName +
                ", documentId=" + documentId +
                ", status=" + status +
                '}';
    }
}
