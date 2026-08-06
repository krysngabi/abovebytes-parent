package com.abovebytes.dtos.penalty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PenaltyDTO(
        @NotBlank(message = "penalty.french.name.required")
        String frenchLabel,

        @NotBlank(message = "penalty.english.name.required")
        String englishLabel,

        @NotNull(message = "penalty.cost.required")
        BigDecimal penaltyCost,

        @NotNull(message = "country.id.required")
        Long countryId
) {
    @Override
    public String toString() {
        return "PenaltyDTO {" +
                ", frenchLabel='" + frenchLabel + '\'' +
                ", englishLabel='" + englishLabel + '\'' +
                ", penaltyCost=" + penaltyCost +
                ", countryId=" + countryId +
                '}';
    }
}
