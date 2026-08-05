package com.abovebytes.dtos.user;

import com.abovebytes.enums.Gender;
import com.abovebytes.enums.RoleValue;
import com.abovebytes.enums.Status;
import com.abovebytes.utils.CommonUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record SelfSignUpRequest(

        @NotBlank(message = "firstname.required")
        String firstname,

        @NotBlank(message = "lastname.required")
        String lastname,

        List<RoleValue> roleValues,

        Status status,

        @NotNull(message = "gender.required")
        Gender gender,

        @NotBlank(message = "new.password.required")
        @Size(min = 5, message = "new.password.at.least.5.chars")
        @Size(max = 99, message = "new.password.max.99.chars")
        String password,

        @NotBlank(message = "confirm.password.required")
        @Size(min = 5, message = "confirm.password.at.least.5.chars")
        @Size(max = 99, message = "confirm.password.max.99.chars")
        String confirmPassword,

        @NotNull(message = "habitation.id.required")
        Long habitationId,

        @NotNull(message = "country.id.required")
        Long countryId,

        @NotBlank(message = "user.phone.required")
        @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "")
        String phone,
        boolean hasAddedNewAddress

) {

    // ✅ compact constructor
    public SelfSignUpRequest {
        if (phone != null) {
            phone = CommonUtils.removePlus(phone);
        }
    }

    // ✅ replace roles completely
    public SelfSignUpRequest withRoleValues(List<RoleValue> newRoles) {
        return new SelfSignUpRequest(
                firstname,
                lastname,
                newRoles,
                status,
                gender,
                password,
                confirmPassword,
                habitationId,
                countryId,
                phone,
                hasAddedNewAddress
        );
    }

    // ✅ add one role
    public SelfSignUpRequest addRole(RoleValue role) {

        List<RoleValue> newRoles = roleValues == null
                ? new ArrayList<>()
                : new ArrayList<>(roleValues);

        newRoles.add(role);

        return new SelfSignUpRequest(
                firstname,
                lastname,
                newRoles,
                status,
                gender,
                password,
                confirmPassword,
                habitationId,
                countryId,
                phone,
                hasAddedNewAddress
        );
    }

    @Override
    public String toString() {
        return "SelfSignUpRequest {" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", countryId=" + countryId +
                ", habitationId=" + habitationId +
                ", status=" + status +
                ", roleValues=" +
                (roleValues == null || roleValues.isEmpty()
                        ? "No roles"
                        : Arrays.toString(roleValues.toArray())) +
                '}';
    }
}