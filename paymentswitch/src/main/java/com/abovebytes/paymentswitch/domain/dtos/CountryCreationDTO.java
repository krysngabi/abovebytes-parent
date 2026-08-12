package com.abovebytes.paymentswitch.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CountryCreationDTO(
        // ISO 3166-1 alpha-2 or ISO 2-letter code
        @NotBlank(message = "country.code.required")
        String code,

        @NotNull(message = "currency.id.required")
        Long currencyId
) {
    @Override
    public String toString() {
        return "CountryCreationDTO {" +
                "code='" + code + '\'' +
                ", currencyId='" + currencyId + '\'' +
                '}';
    }
}
