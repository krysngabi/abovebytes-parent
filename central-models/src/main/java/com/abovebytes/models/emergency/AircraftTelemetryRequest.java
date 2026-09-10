package com.abovebytes.models.emergency;

import io.swagger.v3.oas.annotations.media.Schema;

public record AircraftTelemetryRequest(

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

        @Schema(example = "1789060000000")
        Long timestamp
) {
}