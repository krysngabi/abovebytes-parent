package com.abovebytes.dtos.user;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record EmergencyCallCreationDTO(
        String notes,

        @NotNull(message = "latitude.required")
        BigDecimal latitude,

        @NotNull(message = "longitude.required")
        BigDecimal longitude,

        @NotNull(message = "user.id.required")
        Long userId,

        @NotNull(message = "service.id.required")
        Long serviceId
) {
    @Override
    public String toString() {
        return "EmergencyCallCreationDTO {" +
                "userId='" + userId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", notes=" + notes +
                '}';
    }
}
