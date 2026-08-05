package com.abovebytes.models.requests;

import com.abovebytes.enums.RoleValue;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;


public record RoleRequest(
        @NotNull(message = "user.id.required")
        Long userId,

        @NotNull(message = "role.required")
        RoleValue role,

        List<Long> townshipIds
) {
    @Override
    public String toString() {
        return "RoleRequest {" +
                " userId='" + userId + '\'' +
                " role='" + role.name() + '\'' +
                " townshipIds='" + (townshipIds.isEmpty() ? "No township ids" : Arrays.toString(townshipIds.toArray())) + '\'' +
                '}';
    }
}