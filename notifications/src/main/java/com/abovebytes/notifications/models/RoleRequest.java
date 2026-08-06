package com.abovebytes.notifications.models;

import com.abovebytes.notifications.enums.RoleValue;
import jakarta.validation.constraints.NotNull;
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
                '}';
    }
}