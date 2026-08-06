package com.abovebytes.notifications.models.dtos.websocket;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record ManualPublishDTO(
    @Schema(description = "The target destination path", example = "/topic/dispatcher.track.19")
    @NotBlank(message = "ws.destination.required")
    String destination,

    @Schema(description = "The payload string or JSON string to transmit", example = "{\"status\":\"ACTIVE\",\"latitude\":34.0522,\"longitude\":-118.2437}")
    @NotNull(message = "payload.required")
    Object payload,

    @Schema(description = "The target user's validated principal login name / phone, client_id identity", example = "13024443005, client_id")
    String username,
    String senderId,
    LocalDateTime createdAt,
    String id,
    UUID callId
) {}