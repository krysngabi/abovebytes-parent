package com.abovebytes.notifications.enums;

import com.abovebytes.exceptions.CommonException;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.HttpStatus;

public enum OtpChannel {

    sms,
    whatsapp,
    email,
    call;


    @JsonCreator
    public static OtpChannel fromString(String value) {

        if (value == null) {
            return null;
        }

        try {
            return OtpChannel.valueOf(value.trim().toLowerCase());
        } catch (IllegalArgumentException ex) {
            throw new CommonException(
                    HttpStatus.BAD_REQUEST,
                    value,
                    "400",
                    "Invalid Channel"
            );
        }
    }


}