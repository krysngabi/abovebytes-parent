package com.abovebytes.paymentswitch.domain.enums;

import com.abovebytes.exceptions.CommonException;
import com.abovebytes.utils.MessageUtils;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public enum AllowedApps {
    CC_PAY,
    CENTRAL,
    SYSTEM;

    public static AllowedApps fromString(String allowedApp, MessageUtils messageUtils, Locale locale) {
        try {
            return AllowedApps.valueOf(allowedApp.toUpperCase());
        } catch (IllegalArgumentException ex) {
            String msg = messageUtils.message(
                    "invalid.value",   // key in messages.properties
                    allowedApp, // params for {0} in messages
                    "Invalid value",    // default
                    locale
            );
            throw new CommonException(HttpStatus.BAD_REQUEST, msg, allowedApp, "400");
        }
    }
}
