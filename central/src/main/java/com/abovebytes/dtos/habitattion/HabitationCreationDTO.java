package com.abovebytes.dtos.habitattion;


import com.abovebytes.enums.Gender;
import com.abovebytes.enums.RoleValue;
import com.abovebytes.utils.CommonUtils;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record HabitationCreationDTO(
        @NotBlank(message = "habitation.address.required")
        String address,

        String email,

        String zipCode,

        @NotBlank(message = "habitation.phone.required")
        @Min(value = 7)
        String phone,

        @NotBlank(message = "habitation.owner.firstname.required")
        String firstname,

        @NotBlank(message = "habitation.owner.lastname.required")
        String lastname,

        @NotBlank(message = "habitation.password.required")
        String password,

        @NotNull(message = "gender.required")
        Gender gender,

        @NotBlank(message = "dob.required")
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "invalid.dob")
        String dateOfBirth,

        @Nullable
        RoleValue role,

        String details,

        @NotNull(message = "habitation.province.id.required")
        Long provinceId,

        @NotNull(message = "habitation.ville.id.required")
        Long cityId,

        @NotNull(message = "habitation.township.id.required")
        Long townshipId,

        @NotNull(message = "habitation.quarter.id.required")
        Long quarterId,

        boolean isHouseOwner,
        BigDecimal longitude,
        BigDecimal latitude,
        Long streetId

) {

    /**
     * Compact constructor to sanitize input data.
     */
    public HabitationCreationDTO {
        // Sanitize phone by removing "+" if present
        if (phone != null) {
            phone = CommonUtils.removePlus(phone);
        }
    }

    @Override
    public String toString() {
        return "HabitationCreationDTO {" +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", mai=" + phone +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender.name() + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", details=" + details +
                ", provinceId='" + provinceId + '\'' +
                ", cityId=" + cityId +
                ", townshipId='" + townshipId + '\'' +
                ", quarterId=" + quarterId +
                ", streetId=" + streetId +
                ", longitude=" + longitude +
                ", latitude='" + latitude + '\'' +
                ", isHouseOwner='" + isHouseOwner + '\'' +
                '}';
    }
}
