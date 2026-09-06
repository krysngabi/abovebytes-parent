package com.abovebytes.notifications.models.websocket;

import lombok.Builder;

import java.util.List;

@Builder
public record WebSocketSessionDTO(
        String userId,
        boolean connected,
        int sessionCount,
        List<String> sessions
) {
}