package com.abovebytes.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserSearch(
        @NotBlank(message = "user.search.id.phone.required")
        String userIdOrPhone,

        boolean searchByPhone
) {
    @Override
    public String toString() {
        return "UserSearch {" +
                ", userId='" + userIdOrPhone + '\'' +
                ", userIdOrPhone=" + searchByPhone +
                '}';
    }
}
