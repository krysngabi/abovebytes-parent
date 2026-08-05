package com.abovebytes.dtos.habitattion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProvinceCreationDTO(
        @NotBlank(message = "province.code.required")
        String code,

        @NotBlank(message = "province.name.required")
        String name,

        @NotNull(message = "country.id.required")
        Long countryId
) {
    @Override
    public String toString() {
        return "ProvinceCreationDTO {" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
