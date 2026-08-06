package com.abovebytes.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record UserVehicleRequest(
        @NotNull(message = "vehicle.model.id.required")
        Long vehicleModelId,

        @NotBlank(message = "owner.phone.required")
        String ownerPhone,

        @NotBlank(message = "vin.required")
        @Size(min = 17, max = 17, message = "vin.length")
        @Pattern(regexp = "^[A-HJ-NPR-Z0-9]{17}$", message = "vin.invalid")
        String vin,

        @NotBlank(message = "license.plate.required")
        String licensePlate,

        @NotBlank(message = "vehicle.color.required")
        String color,

        @NotBlank(message = "vehicle.type.required")
        String vehicleType
) {
    @Override
    public String toString() {
        return "UserVehicleRequest {" +
                " vehicleModelId='" + vehicleModelId + '\'' +
                " ownerPhone='" + ownerPhone + '\'' +
                " vin='" + vin + '\'' +
                " licensePlate='" + licensePlate + '\'' +
                " color='" + color + '\'' +
                " vehicleType='" + vehicleType + '\'' +
                '}';
    }
}