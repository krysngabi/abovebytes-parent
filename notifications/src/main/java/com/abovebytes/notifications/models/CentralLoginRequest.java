package com.abovebytes.notifications.models;

public record CentralLoginRequest(
        String phone,
        String password
) {

    @Override
    public String toString() {
        return "CentralLoginRequest{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
