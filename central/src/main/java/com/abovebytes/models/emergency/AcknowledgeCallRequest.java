package com.abovebytes.models.emergency;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AcknowledgeCallRequest(
        @NotNull(message = "emergency.callId.required")
        UUID emergencyCallId,

        @NotBlank(message = "responder.unit.identifier.required")
        String responderUnitIdentifier,

        @NotNull(message = "emergency.priority.required")
        Long priority
) {

    @Override
    public String toString() {
        return "AcknowledgeCallRequest {" +
                "emergencyCallId='" + emergencyCallId + '\'' +
                ", responderUnitIdentifier='" + responderUnitIdentifier + '\'' +
                ", priority=" + priority +
                '}';
    }
}
