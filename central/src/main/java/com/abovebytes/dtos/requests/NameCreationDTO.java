package com.abovebytes.dtos.requests;

import jakarta.validation.constraints.NotBlank;

public record NameCreationDTO(
        @NotBlank(message = "fr.name.required")
        String frenchName,

        @NotBlank(message = "en.name.required")
        String englishName
) {
    @Override
    public String toString() {
        return "NameCreationDTO {" +
                "frenchName='" + frenchName + '\'' +
                "englishName='" + englishName + '\'' +
                '}';
    }
}
