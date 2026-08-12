package com.abovebytes.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private DateUtils() {
    }

    public static LocalDateTime parseLocalDateTime(String date) {
        if (date == null || date.isBlank()) {
            return null;
        }

        String normalized = date.trim()
                .replace("%20", " ")
                .replace(" ", "T");

        return LocalDateTime.parse(
                normalized,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME
        );
    }
}