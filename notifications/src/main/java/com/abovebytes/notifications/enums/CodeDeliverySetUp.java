package com.abovebytes.notifications.enums;

import com.abovebytes.exceptions.CommonException;
import com.abovebytes.utils.MessageUtils;
import org.springframework.http.HttpStatus;
import java.util.Locale;

public enum CodeDeliverySetUp {
    ZERO_TAP_AUTOFILL,
    ONE_TAP_AUTOFILL,
    COPY_CODE;

    public static CodeDeliverySetUp fromString(String codeDeliverySetUp, MessageUtils messageUtils, Locale locale) {
        try {
            return CodeDeliverySetUp.valueOf(codeDeliverySetUp.toUpperCase());
        } catch (IllegalArgumentException ex) {
            String msg = messageUtils.message(
                    "invalid.value",   // key in messages.properties
                    codeDeliverySetUp, // params for {0} in messages
                    "Invalid value",    // default
                    locale
            );
            throw new CommonException(HttpStatus.BAD_REQUEST, msg, codeDeliverySetUp, "400");
        }
    }
}
