package com.abovebytes.models.pymtswitch;


public record LoginRequest(
        String clientId,
        String clientSecret
) {

    @Override
    public String toString() {
        return "PaymentSwitchLoginRequest{" +
                "clientId='" + clientId + '\'' +
                "clientSecret='" + clientSecret.substring(0, 7) + '\'' +
                '}';
    }
}
