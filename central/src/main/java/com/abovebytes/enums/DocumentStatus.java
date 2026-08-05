package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum DocumentStatus {

    PENDING_REVIEW("En attente de révision", "Pending Review", "warning", "#f56905", "NiExclamationSquare"),
    PROCESSING("En cours de traitement", "Processing", "info", "#107de3", "NiArrowDown"),
    PROCESSED("Traité", "Processed", "success", "#28A745", "NiCheckSquare"),
    REJECTED("Rejeté", "Rejected", "error", "#DC3545", "NiCrossSquare"),
    COMPLETED("Terminé", "Completed", "error", "#28A745", "NiCheckSquare"),
    CANCELLED("Annulé", "Cancelled", "grey", "#6C757D", "NiCross");

    private final String frenchDescription;
    private final String englishDescription;
    private final String color;       // semantic label (warning, info, success, etc.)
    private final String statusColor; // actual HEX color
    private final String iconName;

    DocumentStatus(String frenchDescription, String englishDescription, String color, String statusColor, String iconName) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
        this.color = color;
        this.statusColor = statusColor;
        this.iconName = iconName;
    }

    // Retrieve the DocumentStatus from a string representation
    public static DocumentStatus getStatus(String statusString) {
        for (DocumentStatus status : DocumentStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid document status: " + statusString);
    }

    public String getDescription() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishDescription;
        }
        return this.frenchDescription;
    }
}
