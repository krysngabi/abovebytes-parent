package com.abovebytes.paymentswitch.domain.models.enums;

import lombok.Getter;

@Getter
public enum PaymentSwitchProvider {
    ADYEN,
    STRIPE,
    SQUARE,
    PAYPAL;

    public static boolean validateProvider(String provider) {
        for (PaymentSwitchProvider p : PaymentSwitchProvider.values()) {
            if (p.name().equalsIgnoreCase(provider)) {
                return true;
            }
        }
        return false;
    }
}