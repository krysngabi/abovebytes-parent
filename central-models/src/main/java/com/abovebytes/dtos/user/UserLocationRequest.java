package com.abovebytes.dtos.user;


import com.abovebytes.enums.RoleValue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

public record UserLocationRequest(
        @NotNull(message = "user.id.required")
        Long userId,

        @NotNull(message = "radius.required")
        @Min(value = 1000, message = "radius.must.be.or.equal.to.thousand.meters")
        Long radius,

        @NotNull(message = "user.search.type.required")
        List<RoleValue> userSearchTypes,

        int limit
) {

    @Override
    public String toString() {
        return "UserLocationRequest {" +
                " radius='" + radius + '\'' +
                ", userId='" + userId + '\'' +
                ", limit='" + limit + '\'' +
                ", userSearchTypes='" + (userSearchTypes.isEmpty() ? "No userSearchTypes" : Arrays.toString(userSearchTypes.toArray())) + '\'' +
                '}';
    }
}