package com.abovebytes.dtos.country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CountryCreationDTO(
        @NotBlank(message = "country.code.required")
        String code,

        @NotBlank(message = "phone.prefix.required")
        String phonePrefix,

        @NotBlank(message = "time.zone.required")
        String timeZone,

        @NotNull(message = "currency.id.required")
        Long currencyId
) {
    @Override
    public String toString() {
        return "CountryCreationDTO {" +
                "code='" + code + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", phonePrefix='" + phonePrefix + '\'' +
                ", currencyId='" + currencyId + '\'' +
                '}';
    }
}
