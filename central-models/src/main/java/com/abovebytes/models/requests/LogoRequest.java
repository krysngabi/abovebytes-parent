package com.abovebytes.models.requests;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record LogoRequest(
        @NotNull(message = "vehicle.id.required")
        UUID vehicleId,

        @NotNull(message = "logo.id.required")
        Long logoId
) {
    @Override
    public String toString() {
        return "LogoRequest {" +
                " vehicleId='" + vehicleId + '\'' +
                " logoId='" + logoId + '\'' +
                '}';
    }
}