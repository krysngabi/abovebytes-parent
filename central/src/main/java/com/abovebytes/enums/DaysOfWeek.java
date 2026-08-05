package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum DaysOfWeek {
    MONDAY("Lundi", "Monday"),
    TUESDAY("Mardi", "Tuesday"),
    WEDNESDAY("Mercredi", "Wednesday"),
    THURSDAY("Jeudi", "Thursday"),
    FRIDAY("Vendredi", "Friday"),
    SATURDAY("Samedi", "Saturday"),
    SUNDAY("Dimanche", "Sunday");

    private final String frenchDescription;
    private final String englishDescription;

    DaysOfWeek(String frenchDescription, String englishDescription) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
    }

    public String getDescription() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishDescription;
        }
        return this.frenchDescription;
    }

    // Method to retrieve the PaymentStatus from a string representation
    public static DaysOfWeek geDaysOfWeek(String statusString) {
        for (DaysOfWeek status : DaysOfWeek.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid days of week: " + statusString);
    }
}
