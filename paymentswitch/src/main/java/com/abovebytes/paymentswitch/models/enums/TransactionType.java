package com.abovebytes.paymentswitch.models.enums;

import java.util.Arrays;

public enum TransactionType {
    TOP_UP,
    DEBIT;

    /**
     * Converts a string to a TransactionType.
     * Supports case-insensitivity (e.g., "top_up" or "TOP_UP").
     * * @param value The string to convert
     * @return The matching TransactionType or null if not found
     */
    public static TransactionType fromString(String value) {
        if (value == null) return null;

        return Arrays.stream(TransactionType.values())
                .filter(type -> type.name().equalsIgnoreCase(value.trim()))
                .findFirst()
                .orElse(null);
        // Or throw an IllegalArgumentException if you prefer
    }
}