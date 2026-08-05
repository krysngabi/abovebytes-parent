package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum RequestStatus {
    PENDING("En attente", "Pending", "#FF9800"),
    APPROVED("Approuvé", "Approved", "#4CAF50"),
    REJECTED("Refusé", "Rejected", "#F44336");

    private final String frenchLabel;
    private final String englishLabel;
    private final String color;

    RequestStatus(String frenchLabel, String englishLabel, String color) {
        this.frenchLabel = frenchLabel;
        this.englishLabel = englishLabel;
        this.color = color;
    }

    public String getLabel() {
        return "en".equals(LocaleContextHolder.getLocale().getLanguage())
                ? englishLabel
                : frenchLabel;
    }

    public static RequestStatus fromString(String value) {
        for (RequestStatus status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown request status: " + value);
    }
}