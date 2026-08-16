package com.abovebytes.models;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.List;

public record AddApplicationClientRequest(
        String phone,

        @NotNull(message = "app.name.required")
        CreateEnumRequest appName,

        @Nullable
        @Email(message = "invalid.email")
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$", message = "invalid.email")
        String email,

        @NotNull(message = "roles.required")
        List<String> roleValues,

        @NotNull(message = "country.id.required")
        Long countryId
) {


    @Override
    public String toString() {
        return "AddApplicationClientRequest {" +
                "  appName='" + appName.name() + '\'' +
                ", countryId='" + countryId + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + (roleValues == null || roleValues.isEmpty() ? "No roles" : Arrays.toString(roleValues.toArray())) + '\'' +
                '}';
    }
}
