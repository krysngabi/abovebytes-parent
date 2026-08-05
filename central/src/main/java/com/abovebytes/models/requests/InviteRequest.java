package com.abovebytes.models.requests;

import com.abovebytes.enums.Gender;
import jakarta.validation.constraints.NotNull;


public record InviteRequest(
        @NotNull(message = "user.phone.required")
        String userPhone,

        @NotNull(message = "admin.phone.required")
        String adminPhone,

        @NotNull(message = "code.required")
        String code,

        @NotNull(message = "invitee.firstname.required")
        String inviteeFirstname,

        @NotNull(message = "invitee.lastname.required")
        String inviteeLastname,

        @NotNull(message = "is.owner.required")
        Boolean isOwner,

        @NotNull(message = "live.in.same.house.required")
        Boolean liveInSameHouse,

        @NotNull(message = "gender.required")
        Gender gender
) {
    @Override
    public String toString() {
        return "InviteRequest {" +
                " userPhone='" + userPhone + '\'' +
                " adminPhone='" + adminPhone + '\'' +
                " code='" + code + '\'' +
                " inviteeFirstname='" + inviteeFirstname + '\'' +
                " inviteeLastname='" + inviteeLastname + '\'' +
                " isOwner='" + isOwner + '\'' +
                " gender='" + (gender != null ? gender.name() : "No gender") + '\'' +
                " liveInSameHouse='" + liveInSameHouse + '\'' +
                '}';
    }
}