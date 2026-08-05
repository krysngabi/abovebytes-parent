package com.abovebytes.enums;

import lombok.Getter;

@Getter
public enum TaxStatus {
    DISABLED("Désactivé", "Red", "#FF0000"),
    ENABLED("Actif", "Green", "#00FF00"),
    LOCKED("Bloqué", "Red", "#FF0000");

    // Fields for description, severity, and color
    private final String description;
    private final String severity;
    private final String color;

    // Constructor to initialize description, severity, and color
    TaxStatus(String description, String severity, String color) {
        this.description = description;
        this.severity = severity;
        this.color = color;
    }

    // Method to get a status by its name
    public static TaxStatus getStatus(String statusString) {
        for (TaxStatus status : TaxStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + statusString);
    }
}