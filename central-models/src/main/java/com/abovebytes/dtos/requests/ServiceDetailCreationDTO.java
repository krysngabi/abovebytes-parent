package com.abovebytes.dtos.requests;

import com.abovebytes.enums.ServiceCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServiceDetailCreationDTO(
        @NotNull(message = "service.code.required")
        ServiceCode code,

        @NotBlank(message = "service.value.required")
        String value,

        @NotNull(message = "country.id.required")
        Long countryId,

        Boolean isPhoneNumber
) {
    public ServiceDetailCreationDTO {
        if (isPhoneNumber == null) {
            isPhoneNumber = true;
        }
    }

    @Override
    public String toString() {
        return "ServiceDetailCreationDTO {" +
                "code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", countryId=" + countryId +
                ", countryId=" + countryId +
                '}';
    }
}
