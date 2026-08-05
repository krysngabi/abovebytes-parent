package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;
import java.util.EnumSet;

/**
 * Enum representing various statuses with their descriptions, severity, color, and associated status types.
 * This enum is used to manage the state of vehicles, users, payments, notifications, and invites in the application.
 */
@Getter
public enum Status {
    REGISTERED("En ordre", "Registered", "Green", "#00FF00", EnumSet.of(StatusType.VEHICLE)),
    STOLEN("Volé", "Stolen", "Red", "#FF0000", EnumSet.of(StatusType.VEHICLE)),
    TEMPORARY_PASSWORD_UNUSED("Mot de passe temporaire non utilisé", "Unused temporary password", "Yellow", "#FFFF00", EnumSet.of(StatusType.PASSWORD)),
    TEMPORARY_PASSWORD_USED("Mot de passe temporaire utilisé", "Temporary password used", "Green", "#00FF00", EnumSet.of(StatusType.PASSWORD)),
    WARNED("Sous Avertissement", "Warned", "Yellow", "#999900", EnumSet.of(StatusType.VEHICLE)),
    MAINTENANCE("En maintenance", "Maintenance", "Yellow", "#FFFF00", EnumSet.of(StatusType.VEHICLE)),
    DECOMMISSIONED("Plus en Service", "Decommissioned", "Red", "#FF0000", EnumSet.of(StatusType.VEHICLE)),
    SOLD("Vendu", "Sold", "Green", "#00FF00", EnumSet.of(StatusType.VEHICLE)),
    LEASED("En location", "Leased", "Green", "#00FF00", EnumSet.of(StatusType.VEHICLE)),
    INSURED("Assuré", "Insured", "Green", "#00FF00", EnumSet.of(StatusType.VEHICLE)),
    UNINSURED("Non Assuré", "Uninsured", "Red", "#FF0000", EnumSet.of(StatusType.VEHICLE)),
    DAMAGED("Declassé", "Damaged", "Red", "#FF0000", EnumSet.of(StatusType.VEHICLE)),
    ACCEPTED("Accepté", "Accepted", "Green", "#00FF00", EnumSet.of(StatusType.PAYMENT, StatusType.INVITE)),
    ANSWERED("Repondu", "Answered", "Green", "#00FF00", EnumSet.of(StatusType.NOTIFICATION)),
    DECLINED("Refusé", "Declined", "Red", "#FF0000", EnumSet.of(StatusType.PAYMENT)),
    DELETED("Effacé", "Deleted", "Red", "#FF0000", EnumSet.of(StatusType.NOTIFICATION)),
    DISABLED("Désactivé", "Disabled", "Red", "#FF0000", EnumSet.of(StatusType.USER, StatusType.VEHICLE)),
    DISPATCHED("Dispatché", "Dispatched", "Yellow", "#FFFF00", EnumSet.of(StatusType.VEHICLE)),
    ENABLED("Actif", "Enabled", "Green", "#00FF00", EnumSet.of(StatusType.USER, StatusType.VEHICLE, StatusType.PAYMENT)),
    NOT_ACCEPTED("Non Accepté", "Not Accepted", "Yellow", "#FFFF00", EnumSet.of(StatusType.INVITE)),
    READ("Lu", "Read", "Green", "#00FF00", EnumSet.of(StatusType.NOTIFICATION)),
    UNREAD("Non Lu", "Unread", "Yellow", "#FFFF00", EnumSet.of(StatusType.NOTIFICATION)),
    PENDING_REVIEW("En attente de révision", "Pending Review", "Orange", "#f55a07", EnumSet.of(StatusType.PICTURE)),
    ID_DECLINED("Pièce rejetée", "ID Declined", "Red", "#FF0000", EnumSet.of(StatusType.PICTURE)),
    ID_VERIFIED("Pièce verifiée", "ID Verified", "Green", "#00FF00", EnumSet.of(StatusType.PICTURE)),
    PASSWORD_EXPIRED("Mot de passe expiré", "Password Expired", "Red", "#FF0000", EnumSet.of(StatusType.PASSWORD));

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

