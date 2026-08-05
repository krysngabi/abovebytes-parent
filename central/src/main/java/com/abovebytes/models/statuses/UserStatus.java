package com.abovebytes.models.statuses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Arrays;
import java.util.List;

@Getter
public enum UserStatus {

    ENABLED(
            "Actif",
            "Enabled",
            "Green",
            "#00FF00"
    ),

    DISABLED(
            "Désactivé",
            "Disabled",
            "Red",
            "#FF0000"
    ),

    SUSPENDED(
            "Suspendu",
            "Suspended",
            "Yellow",
            "#FFFF00"
    ),

    PENDING_VERIFICATION(
            "En attente de vérification",
            "Pending Verification",
            "Yellow",
            "#FFFF00"
    ),

    INVITED(
            "Invité",
            "Invited",
            "Blue",
            "#0000FF"
    ),

    LOCKED(
            "Verrouillé",
            "Locked",
            "Red",
            "#FF0000"
    ),

    REQUESTED_FORGOT_PASSWORD(
            "Mot de passe oublié demandé",
            "Forgot Password Requested",
            "Yellow",
            "#FFFF00"
    ),

    PASSWORD_EXPIRED(
            "Mot de passe expiré",
            "Password Expired",
            "Red",
            "#FF0000"
    ),

    ACCOUNT_DELETION_REQUESTED(
            "Suppression du compte demandée",
            "Account deletion requested",
            "Yellow",
            "#FFFF00"
    ),

    PENDING_REVIEW("En attente de révision", "Pending Review", "Orange", "#f55a07"),
    ID_DECLINED("Pièce rejetée", "ID Declined", "Red", "#FF0000"),
    ID_VERIFIED("Pièce verifiée", "ID Verified", "Green", "#00FF00");

    private final String frenchDescription;
    private final String englishDescription;
    private final String severity;
    private final String color;

    UserStatus(
            String frenchDescription,
            String englishDescription,
            String severity,
            String color
    ) {
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

    public static UserStatus getStatus(String statusString) {
        for (UserStatus status : UserStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid user status: " + statusString);
    }

    public static List<UserStatusDTO> getUserStatuses() {
        return Arrays.stream(UserStatus.values())
                .map(status -> new UserStatusDTO(
                        status.name(),
                        status.getDescription(),
                        status.getSeverity(),
                        status.getColor()
                ))
                .toList();
    }


    @Getter
    @AllArgsConstructor
    public static class UserStatusDTO {
        private final String name;
        private final String description;
        private final String severity;
        private final String color;
    }
}