package com.abovebytes.dtos.penalty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TrafficDTO(
        @NotNull(message = "vehicle.id.required")
        UUID vehicleId,

        @NotNull(message = "license.plate.required")
        String licensePlate,

        @NotNull(message = "penalty.id.required")
        UUID penaltyId,

        @NotBlank(message = "incident.location.required")
        String incidentLocation,

        @NotNull(message = "amount.received.required")
        BigDecimal amountReceived,

        @NotNull(message = "latitude.required")
        BigDecimal latitude,

        @NotNull(message = "longitude.required")
        BigDecimal longitude
) {
    @Override
    public String toString() {
        return "TrafficDTO {" +
                "  vehicleId='" + vehicleId + '\'' +
                ", penaltyId='" + penaltyId + '\'' +
                ", incidentLocation='" + incidentLocation + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", amountReceived=" + amountReceived +
                '}';
    }
}
