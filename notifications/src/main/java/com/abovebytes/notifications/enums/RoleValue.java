package com.abovebytes.notifications.enums;

import com.abovebytes.exceptions.CommonException;
import com.abovebytes.utils.MessageUtils;
import org.springframework.http.HttpStatus;
import java.util.Locale;

public enum RoleValue {
    APPLICATION,
    TWILIO,
    SUPER_ADMIN;

    public static RoleValue fromString(String role, MessageUtils messageUtils, Locale locale) {
        try {
            return RoleValue.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException ex) {
            String msg = messageUtils.message(
                    "invalid.value",   // key in messages.properties
                    role, // params for {0} in messages
                    "Invalid value",    // default
                    locale
            );
            throw new CommonException(HttpStatus.BAD_REQUEST, msg, role, "400");
        }
    }
}