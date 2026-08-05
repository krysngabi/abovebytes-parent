package com.abovebytes.dtos.habitattion;

import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

public record StreetCreationDTO(
        @NotNull(message = "street.names.required")
        List<String> streetNames,

        @NotNull(message = "quarter.id.required")
        Long quarterId
) {
    @Override
    public String toString() {
        return "StreetCreationDTO {" +
                ", streetNames='" + (streetNames.isEmpty() ? "No street names provided" : Arrays.toString(streetNames.toArray())) + '\'' +
                ", quarterId=" + quarterId +
                '}';
    }
}
