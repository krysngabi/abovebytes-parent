package com.abovebytes.notifications.models;

import com.abovebytes.notifications.enums.RoleValue;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Arrays;
import java.util.List;

public record AddUserRequest(
        String phone,

        @NotNull(message = "app.name.required")
        CreateEnumRequest appName,

        @Nullable
        @Email(message = "invalid.email")
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$", message = "invalid.email")
        String email,

        @NotNull(message = "roles.required")
        List<RoleValue> roleValues
) {


    @Override
    public String toString() {
        return "AddUserRequest {" +
                "  appName='" + appName.name() + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + (roleValues == null || roleValues.isEmpty() ? "No roles" : Arrays.toString(roleValues.toArray())) + '\'' +
                '}';
    }
}
