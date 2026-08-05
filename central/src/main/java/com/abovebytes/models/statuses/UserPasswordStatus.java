package com.abovebytes.models.statuses;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum UserPasswordStatus {
    // Be careful before changing these as the mobile rely on these to display the user warning message
    // If you are updating an existing status make sure the mobile part is updated as well
    VALID("Valide", "Valid"),
    EXPIRED("Expiré", "Expired"),
    WARNING("Bientôt expiré", "Warning");

    private final String frenchDescription;
    private final String englishDescription;

    UserPasswordStatus(String frenchDescription, String englishDescription) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
    }

    // Retrieve enum from string
    public static UserPasswordStatus getStatus(String statusString) {
        for (UserPasswordStatus status : UserPasswordStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid user password status: " + statusString);
    }

    public String getDescription() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishDescription;
        }
        return this.frenchDescription;
    }
}
