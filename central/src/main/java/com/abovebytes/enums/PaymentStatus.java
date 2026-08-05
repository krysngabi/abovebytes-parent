package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum PaymentStatus {
    PAID("Payé", "Paid", "Green", "#00FF00"),          // Partial payment received
    UNPAID("Non payé", "Unpaid", "Orange", "#FFA500"),
    PENDING("En attente", "Pending", "Orange", "#FFA500"),
    FAILED("Échoué", "Failed",  "Red", "#FF0000"),
    CANCELED("Annulé",  "Canceled", "Grey", "#808080"),
    REFUNDED("Remboursé",  "Refunded", "Blue", "#0000FF"),
    EXPIRED("Expiré",  "Expired", "Grey", "#A9A9A9"),
    PARTIALLY_PAID("Payé partiellement",  "Partially paid", "Blue", "#1E90FF"),
    COMPLETED("Terminé",  "Completed", "Green", "#00FF00");          // Payment was canceled

    private final String frenchDescription;
    private final String englishDescription;
    private final String severity;
    private final String color;

    PaymentStatus(String frenchDescription, String englishDescription, String severity, String color) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
        this.severity = severity;
        this.color = color;
    }

    public String getDescription() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishDescription;
        }
        return this.frenchDescription;
    }

    public static PaymentStatus getStatus(String statusString) {
        for (PaymentStatus status : PaymentStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + statusString);
    }
}
