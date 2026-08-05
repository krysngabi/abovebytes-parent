package com.abovebytes.models.notificationservice;

public record LoginRequest(
        String clientId,
        String clientSecret
) {

    @Override
    public String toString() {
        return "LoginRequest{" +
                "clientId='" + clientId + '\'' +
                '}';
    }
}
