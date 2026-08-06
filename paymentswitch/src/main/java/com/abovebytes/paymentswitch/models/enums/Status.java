package com.abovebytes.paymentswitch.models.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.EnumSet;

/**
 * Enum representing various statuses with their descriptions, severity, color, and associated status types.
 * This enum is used to manage the state of vehicles, users, payments, notifications, and invites in the application.
 */
@Getter
public enum Status {
    SUSPENDED("Suspendu", "Suspended", "Yellow", "#FFFF00", EnumSet.of(StatusType.USER)),
    MAINTENANCE("En maintenance", "Maintenance", "Yellow", "#FFFF00", EnumSet.of(StatusType.VEHICLE)),
    DISABLED("Désactivé", "Disabled", "Red", "#FF0000", EnumSet.of(StatusType.USER, StatusType.VEHICLE)),
    ENABLED("Actif", "Enabled", "Green", "#00FF00", EnumSet.of(StatusType.USER, StatusType.VEHICLE, StatusType.PAYMENT));

    private final String frenchDescription;
    private final String englishDescription;
    private final String severity;
    private final String color;
    private final EnumSet<StatusType> statusTypes;

    Status(String frenchDescription, String englishDescription, String severity, String color, EnumSet<StatusType> statusTypes) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
        this.severity = severity;
        this.color = color;
        this.statusTypes = statusTypes;
    }

    public String getDescription() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishDescription;
        }
        return this.frenchDescription;
    }

    public boolean isValidForType(StatusType statusType) {
        return statusTypes.contains(statusType);
    }

    public static Status getStatus(String statusString) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + statusString);
    }

    public enum StatusType {
        USER,
        VEHICLE,
        PAYMENT,
        NOTIFICATION,
        INVITE,
        PICTURE,
        PASSWORD
    }
}

