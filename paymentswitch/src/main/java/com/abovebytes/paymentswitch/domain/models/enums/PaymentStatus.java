package com.abovebytes.paymentswitch.domain.models.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Arrays;

@Getter
public enum PaymentStatus {
    PAID("Payé", "Paid", "Green", "#00FF00"),
    PENDING("En attente", "Pending", "Orange", "#FFA500"),
    UNPAID("Non payé", "Unpaid", "Orange", "#FFA500"),
    INITIATED("Initié", "Initiated", "Grey", "#808080"),
    FAILED("Échoué", "Failed",  "Red", "#FF0000"),
    CANCELED("Annulé",  "Canceled", "Grey", "#808080"),
    REFUNDED("Remboursé",  "Refunded", "Blue", "#0000FF"),
    EXPIRED("Expiré",  "Expired", "Grey", "#A9A9A9"),
    PARTIALLY_PAID("Payé partiellement",  "Partially paid", "Blue", "#1E90FF"),
    COMPLETED("Terminé",  "Completed", "Green", "#00FF00"),
    PROCESSING("En traitement", "Processing", "Orange", "#FFA500"),
    SUCCEEDED("Réussi", "Succeeded", "Green", "#00FF00"),
    PARTIALLY_REFUNDED("Partiellement remboursé", "Partially refunded", "Blue", "#1E90FF"),
    ;          // Payment was canceled

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
        if (statusString == null || statusString.isBlank()) {
            throw new IllegalArgumentException("Payment status cannot be null or blank.");
        }

        return Arrays.stream(PaymentStatus.values())
                .filter(status -> status.name().equalsIgnoreCase(statusString.trim()))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid payment status: " + statusString));
    }
}
