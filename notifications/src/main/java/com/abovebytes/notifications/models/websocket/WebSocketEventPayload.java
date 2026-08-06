package com.abovebytes.notifications.models.websocket;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebSocketEventPayload {

    private String type;

    private String reason;

    private String userId;

    private String username;

    private String sessionId;

    private String serverTime;

    private String correlationId;

    private String message;

    private Map<String, Object> metadata;
}