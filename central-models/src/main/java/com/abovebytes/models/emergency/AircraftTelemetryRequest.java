package com.abovebytes.models.emergency;

import io.swagger.v3.oas.annotations.media.Schema;

public record AircraftTelemetryRequest(

        @Schema(example = "DJI Mini 4 Pro")
        String deviceName,

        @Schema(example = "87")
        Integer batteryPercent,

        @Schema(example = "34.063191")
        Double latitude,

        @Schema(example = "-118.121621")
        Double longitude,

        @Schema(example = "1.1")
        Double altitude,

        @Schema(description = "Aircraft roll angle")
        Double roll,

        @Schema(description = "Aircraft pitch angle")
        Double pitch,

        @Schema(description = "Aircraft yaw angle")
        Double yaw,

        @Schema(description = "Aircraft X position")
        Double x,

        @Schema(description = "Aircraft Y position")
        Double y,

        @Schema(description = "Aircraft Z position")
        Double z,

        @Schema(description = "Aircraft X velocity")
        Double vx,

        @Schema(description = "Aircraft Y velocity")
        Double vy,

        @Schema(description = "Aircraft Z velocity")
        Double vz,

        @Schema(description = "Whether the aircraft is currently flying")
        Boolean isFlying,

        @Schema(description = "Aircraft flight time in seconds")
        Integer flightTimeSeconds,

        @Schema(example = "1789060000000")
        Long timestamp
) {
}