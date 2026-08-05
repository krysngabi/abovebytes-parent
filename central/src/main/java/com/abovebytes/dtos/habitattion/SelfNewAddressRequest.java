package com.abovebytes.dtos.habitattion;


import com.abovebytes.enums.Gender;
import com.abovebytes.utils.CommonUtils;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SelfNewAddressRequest(
        String address,

        String email,

        String zipCode,

        @NotBlank(message = "habitation.phone.required")
        @Min(value = 7)
        String phone,

        @NotNull(message = "gender.required")
        Gender gender,

        @NotNull(message = "habitation.province.id.required")
        Long provinceId,

        @NotNull(message = "habitation.ville.id.required")
        Long cityId,

        @NotNull(message = "habitation.township.id.required")
        Long townshipId,

        @NotNull(message = "habitation.quarter.id.required")
        Long quarterId,
        Long streetId

) {

    /**
     * Compact constructor to sanitize input data.
     */
    public SelfNewAddressRequest {
        // Sanitize phone by removing "+" if present
        if (phone != null) {
            phone = CommonUtils.removePlus(phone);
        }
    }

    @Override
    public String toString() {
        return "SelfNewAddressRequest {" +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", mai=" + phone +
                ", gender='" + gender.name() + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", cityId=" + cityId +
                ", townshipId='" + townshipId + '\'' +
                ", quarterId=" + quarterId +
                ", streetId=" + streetId +
                '}';
    }
}
