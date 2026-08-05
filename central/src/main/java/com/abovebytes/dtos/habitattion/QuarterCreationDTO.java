package com.abovebytes.dtos.habitattion;

import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

public record QuarterCreationDTO(
        @NotNull(message = "quarter.names.required")
        List<String> quarterNames,

        @NotNull(message = "township.id.required")
        Long townshipId
) {
    @Override
    public String toString() {
        return "QuarterCreationDTO {" +
                ", quarterNames='" + (quarterNames.isEmpty() ? "No quarters" : Arrays.toString(quarterNames.toArray())) + '\'' +
                ", townshipId=" + townshipId +
                '}';
    }
}
