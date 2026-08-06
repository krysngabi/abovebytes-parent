package com.abovebytes.dtos.requests;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record NameDescriptionCreationDTO(
        @NotBlank(message = "category.name.required")
        String name,

        @NotBlank(message = "category.en.desc.required")
        String englishDesc,

        @NotBlank(message = "category.fr.desc.required")
        String frenchDesc,

        BigDecimal cost,
        Long currencyId
) {
    @Override
    public String toString() {
        return "NameDescriptionCreationDTO {" +
                "name='" + name + '\'' +
                ", englishDesc='" + englishDesc + '\'' +
                ", frenchDesc='" + frenchDesc + '\'' +
                ", cost='" + cost + '\'' +
                ", currencyId='" + currencyId + '\'' +
                '}';
    }
}
