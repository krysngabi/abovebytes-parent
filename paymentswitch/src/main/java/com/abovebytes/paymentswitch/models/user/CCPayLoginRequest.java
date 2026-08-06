package com.abovebytes.paymentswitch.models.user;


public record CCPayLoginRequest(
        String phone,
        String password
) {

    @Override
    public String toString() {
        return "CCPayLoginRequest{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
