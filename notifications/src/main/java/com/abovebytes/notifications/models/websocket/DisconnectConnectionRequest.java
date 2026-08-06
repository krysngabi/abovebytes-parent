package com.abovebytes.notifications.models.websocket;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DisconnectConnectionRequest(
        @NotNull(message = "username.required")
        String username,

        @Schema(description = "The target destination path", example = "/topic/dispatcher.track.19")
        @NotBlank(message = "ws.destination.required")
        String destination,

        String sessionId,
        String reason,
        String disconnectionMessage
) {

    @Override
    public String toString() {
        return "DisconnectConnectionRequest {" +
                "username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
