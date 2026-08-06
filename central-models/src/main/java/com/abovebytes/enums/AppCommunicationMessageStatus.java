package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum AppCommunicationMessageStatus {
    DRAFT("Brouillon", "Draft", "Blue Gray", "#607D8B"),
    SCHEDULED("Planifié", "Scheduled", "Teal", "#009688"),
    SENT("Envoyé", "Sent", "Green", "#4CAF50"),
    DELIVERED("Distribué", "Delivered", "Blue", "#2196F3"),
    READ("Lu", "Read", "Green", "#00FF00"),
    DISMISSED("Ignoré", "Dismissed", "Gray", "#9E9E9E"),
    EXPIRED("Expiré", "Expired", "Orange", "#FFA500"),
    FAILED("Échec", "Failed", "Red", "#FF0000"),
    CANCELLED("Annulé", "Cancelled", "Gray", "#A0A0A0");

    private final String frenchDescription;
    private final String englishDescription;
    private final String severity;
    private final String severityColor;

    AppCommunicationMessageStatus(String frenchDescription, String englishDescription, String severity, String severityColor) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
        this.severity = severity;
        this.severityColor = severityColor;
    }

    public String getDescription() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return englishDescription;
        }
        return frenchDescription;
    }

    public static AppCommunicationMessageStatus fromString(String status) {
        for (AppCommunicationMessageStatus s : values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid AppCommunicationMessageStatus: " + status);
    }
}
