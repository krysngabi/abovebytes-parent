package com.abovebytes.paymentswitch.models.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Enum representing various statuses with their descriptions, severity, color.
 */
@Getter
public enum MerchantOnBoardingStatus {
    INITIATED("Initié", "Initiated", "Yellow", "#FFFF00"),
    COMPLETED("Completé", "Completed", "Green", "#00FF00"),
    FAILED("Échoué", "Failed", "Red", "#FF0000");

    private final String frenchDescription;
    private final String englishDescription;
    private final String severity;
    private final String color;

    MerchantOnBoardingStatus(String frenchDescription, String englishDescription, String severity, String color) {
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

    public static MerchantOnBoardingStatus getStatus(String statusString) {
        for (MerchantOnBoardingStatus status : MerchantOnBoardingStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid merchant onboarding status: " + statusString);
    }
}

