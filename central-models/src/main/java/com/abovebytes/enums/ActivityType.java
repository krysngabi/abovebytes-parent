package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum ActivityType {
    USER_CREATION("Création d'utilisateur", "User creation", "#4CAF50"),
    USER_UPDATE("Mise à jour de l'utilisateur", "User update", "#2196F3"),
    USER_STATUS_UPDATE("Changement de statut d'utilisateur", "User status update", "#FF9800"),
    USER_DELETION("Suppression d'utilisateur", "User deletion", "#F44336"),

    ROLE_CREATION("Création de rôle", "Role creation", "#4CAF50"),
    ROLE_UPDATE("Mise à jour de rôle", "Role update", "#2196F3"),
    ROLE_DELETION("Suppression de rôle", "Role deletion", "#F44336"),

    HOUSE_CREATION("Création de maison", "House creation", "#4CAF50"),
    HOUSE_UPDATE("Mise à jour de maison", "House update", "#2196F3"),
    HOUSE_DELETION("Suppression de maison", "House deletion", "#F44336"),

    VEHICLE_REGISTRATION("Enregistrement du véhicule", "Vehicle registration", "#4CAF50"),
    VEHICLE_UPDATE("Mise à jour du véhicule", "Vehicle update", "#2196F3"),
    VEHICLE_REMOVAL("Suppression du véhicule", "Vehicle removal", "#F44336"),

    TICKET_CREATION("Création de contravention", "Ticket creation", "#FF9800"),
    TICKET_PAYMENT("Paiement de contravention", "Ticket payment", "#4CAF50"),
    TICKET_CANCELLATION("Annulation de contravention", "Ticket cancellation", "#F44336"),

    DOCUMENT_UPLOAD("Téléversement de document", "Document upload", "#4CAF50"),
    DOCUMENT_DELETION("Suppression de document", "Document deletion", "#F44336"),

    NOTIFICATION_SENT("Notification envoyée", "Notification sent", "#2196F3"),
    ALERT_TRIGGERED("Alerte déclenchée", "Alert triggered", "#FF5722"),
    ACCOUNT_VERIFICATION("Compte verifié", "Account verified", "#2196F3"),
    INVITE_ACCEPTED("Invitation acceptée", "Invite accepted", "#2196F3"),

    LOGIN("Connexion", "Login", "#8BC34A"),
    LOGOUT("Déconnexion", "Logout", "#FFC107"),
    PASSWORD_CHANGE("Changement de mot de passe", "Password change", "#607D8B");

    private final String frenchLabel;
    private final String englishLabel;
    private final String severityColor;

    ActivityType(String frenchLabel, String englishLabel, String severityColor) {
        this.frenchLabel = frenchLabel;
        this.englishLabel = englishLabel;
        this.severityColor = severityColor;
    }

    public String getLabel() {
        return "en".equals(LocaleContextHolder.getLocale().getLanguage())
                ? englishLabel
                : frenchLabel;
    }

    public static ActivityType fromString(String value) {
        for (ActivityType type : values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown activity type: " + value);
    }
}
