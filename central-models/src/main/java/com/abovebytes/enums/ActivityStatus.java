package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public enum ActivityStatus {
    UNREAD("Non Lu", "Unread", "Yellow", "#FFFF00"),
    READ("Lu", "Read", "Green", "#00FF00"),
    ARCHIVED("Archivé", "Archived", "Gray", "#A0A0A0"),
    DELETED("Supprimé", "Deleted", "Red", "#FF0000"),
    HIDDEN("Masqué", "Hidden", "Gray", "#808080"),
    PINNED("Épinglé", "Pinned", "Blue", "#2196F3"),
    UNPINNED("Désépinglé", "Unpinned", "Gray", "#9E9E9E"),
    IMPORTANT("Important", "Important", "Red", "#D32F2F"),
    EXPIRED("Expiré", "Expired", "Orange", "#FFA500"),
    ACTION_REQUIRED("Action requise", "Action Required", "Orange", "#FFA726"),
    COMPLETED("Complété", "Completed", "Green", "#4CAF50"),
    IN_PROGRESS("En cours", "In Progress", "Blue", "#2196F3"),
    FAILED("Échoué", "Failed", "Red", "#FF0000"),
    CANCELLED("Annulé", "Cancelled", "Gray", "#9E9E9E"),
    SENT("Envoyé", "Sent", "Green", "#4CAF50"),
    SCHEDULED("Planifié", "Scheduled", "Teal", "#009688"),
    DRAFT("Brouillon", "Draft", "Blue Gray", "#607D8B"),
    PENDING_REVIEW("En attente de révision", "Pending Review", "Orange", "#FFA500"),
    // Workflow / Processing
    PENDING("En attente", "Pending", "Orange", "#FF9800"),
    PROCESSING("En traitement", "Processing", "Blue", "#03A9F4"),
    ON_HOLD("En attente", "On Hold", "Amber", "#FFC107"),
    APPROVED("Approuvé", "Approved", "Green", "#4CAF50"),
    REJECTED("Rejeté", "Rejected", "Red", "#F44336"),
    // Notification specific
    DELIVERED("Livré", "Delivered", "Green", "#66BB6A"),
    SEEN("Vu", "Seen", "Blue", "#42A5F5"),
    DISMISSED("Ignoré", "Dismissed", "Gray", "#9E9E9E"),
    // Tasks / Follow-ups
    ASSIGNED("Attribué", "Assigned", "Blue", "#1976D2"),
    REOPENED("Rouvert", "Reopened", "Purple", "#7B1FA2"),
    RESOLVED("Résolu", "Resolved", "Green", "#388E3C"),
    // System
    SYNCED("Synchronisé", "Synced", "Green", "#43A047"),
    SYNC_FAILED("Échec de synchronisation", "Sync Failed", "Red", "#E53935"),
    QUEUED("En file d'attente", "Queued", "Blue Gray", "#78909C"),
    // Time-based
    OVERDUE("En retard", "Overdue", "Red", "#D32F2F"),
    PAUSED("En pause", "Paused", "Amber", "#FFB300");

    private final String frenchDescription;
    private final String englishDescription;
    private final String severity;
    private final String severityColor;

    ActivityStatus(String frenchDescription, String englishDescription, String severity, String severityColor) {
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

    public static ActivityStatus fromString(String status) {
        for (ActivityStatus s : values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid activity status: " + status);
    }
}
