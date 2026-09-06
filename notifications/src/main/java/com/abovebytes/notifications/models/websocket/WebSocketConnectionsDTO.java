package com.abovebytes.notifications.models.websocket;

import lombok.Builder;

import java.util.List;

@Builder
public record WebSocketConnectionsDTO(
        int connectedUserCount,
        int totalSessionCount,
        List<WebSocketSessionDTO> users
) {
}