package com.abovebytes.dtos.habitattion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CityCreationDTO(
        @NotBlank(message = "city.label.required")
        String label,

        @NotNull(message = "township.id.required")
        Long provinceId
) {
    @Override
    public String toString() {
        return "CityCreationDTO {" +
                ", value='" + label + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}
