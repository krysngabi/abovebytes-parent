package com.abovebytes.dtos.habitattion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TownshipCreationDto(
        @NotBlank(message = "township.label.required")
        String label,

        @NotNull(message = "city.id.required")
        Long cityId
) {
    @Override
    public String toString() {
        return "TownshipCreationDto {" +
                ", label='" + label + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
