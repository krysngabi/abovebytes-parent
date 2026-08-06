package com.abovebytes.paymentswitch.models.enums;

import com.abovebytes.utils.MessageUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EnvironmentMode {

    TEST("environment.mode.test"),
    LIVE("environment.mode.live");

    private final String messageKey;

    EnvironmentMode(String messageKey) {
        this.messageKey = messageKey;
    }

    @JsonCreator
    public static EnvironmentMode from(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        return Arrays.stream(EnvironmentMode.values())
                .filter(mode -> mode.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("environment.mode.invalid")
                );
    }

    @JsonValue
    public String toValue() {
        return name();
    }

    public String message(MessageUtils messageUtils) {
        return messageUtils.message(this.messageKey);
    }
}
