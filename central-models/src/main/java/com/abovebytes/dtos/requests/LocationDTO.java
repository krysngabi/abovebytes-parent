package com.abovebytes.dtos.requests;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record LocationDTO(
        @NotNull(message = "longitude.required")
        BigDecimal longitude,

        @NotNull(message = "latitude.required")
        BigDecimal latitude,

        @NotNull(message = "user.id.required")
        Long userId,

        UUID emergencyCallId
) {
    @Override
    public String toString() {
        return "LocationDTO {" +
                "emergencyCallId='" + emergencyCallId + '\'' +
                "userId='" + userId + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
