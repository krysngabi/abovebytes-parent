package com.abovebytes.models.emergency;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Enum representing the triage priority tiers assigned to an emergency call.
 * Includes explicit localized descriptions, operational scenarios, and frontend UI hints.
 * Lower numeric level = higher urgency (1 = most critical).
 */
@Getter
public enum CallPriority {

    CRITICAL(
            1,
            "Critique",
            "Critical",
            "#EA5455",
            "Menace immédiate pour la vie. Nécessite une réponse et une répartition instantanées.",
            "Immediate threat to life. Requires instant response and dispatch.",
            "Deep Red",
            "Maximum Urgency Flash"
    ),
    HIGH(
            2,
            "Élevée",
            "High",
            "#FF9F43",
            "Situation grave nécessitant une intervention rapide, mais pas de danger de mort immédiat confirmé.",
            "Serious situation requiring fast intervention, but no confirmed immediate life threat.",
            "Orange",
            "Pulsing Warning"
    ),
    MEDIUM(
            3,
            "Moyenne",
            "Medium",
            "#00CFE8",
            "Priorité par défaut assignée avant triage. Nécessite un examen de l'opérateur pour reclassification.",
            "Default priority assigned pre-triage. Requires operator review for reclassification.",
            "Cyan",
            "Solid Notice"
    ),
    LOW(
            4,
            "Faible",
            "Low",
            "#1B9CFC",
            "Non urgent. Peut être traité après les appels de priorité plus élevée.",
            "Non-urgent. Can be handled after higher-priority calls.",
            "Blue",
            "Muted Badge"
    ),
    UNREVIEWED(
            0,
            "Non examinée",
            "Unreviewed",
            "#82868B",
            "Appel pas encore examiné par un opérateur. Aucune priorité confirmée.",
            "Call not yet reviewed by an operator. No confirmed priority.",
            "Light Grey",
            "Pending Review Icon"
    );

    private final int level;
    private final String frenchDescription;
    private final String englishDescription;
    private final String color; // Hex string target representation
    private final String frenchUsageScenario;
    private final String englishUsageScenario;
    private final String colorHint;
    private final String uiPresentation;

    CallPriority(int level,
                 String frenchDescription,
                 String englishDescription,
                 String color,
                 String frenchUsageScenario,
                 String englishUsageScenario,
                 String colorHint,
                 String uiPresentation) {
        this.level = level;
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
        this.color = color;
        this.frenchUsageScenario = frenchUsageScenario;
        this.englishUsageScenario = englishUsageScenario;
        this.colorHint = colorHint;
        this.uiPresentation = uiPresentation;
    }

    public String getDescription() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishDescription;
        }
        return this.frenchDescription;
    }

    public String getUsageScenario() {
        if ("en".equals(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishUsageScenario;
        }
        return this.frenchUsageScenario;
    }

    public static CallPriority getPriority(String priorityString) {
        for (CallPriority priority : CallPriority.values()) {
            if (priority.name().equalsIgnoreCase(priorityString)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid call priority: " + priorityString);
    }

    public static CallPriority fromLevel(int level) {
        for (CallPriority priority : CallPriority.values()) {
            if (priority.level == level) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid call priority level: " + level);
    }
}