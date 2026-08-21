package com.abovebytes.models.emergency;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Enum representing the real-time lifecycle states of an emergency call dispatch sequence.
 * Includes explicit localized descriptions, operational scenarios, and frontend UI hints.
 */
@Getter
public enum CallStatus {

    ASSIGNED(
            "Assigné",
            "Assigned",
            "MEDIUM",
            "#2563EB",
            "Le ticket a été attribué à un technicien ou à une équipe pour traitement.",
            "The ticket has been assigned to a technician or team for processing.",
            "Blue",
            "Primary Action"
    ),

    // 1. INTAKE & TRIAGE POOL
    PENDING(
            "En attente",
            "Pending",
            "HIGH",
            "#FF9F43",
            "L'utilisateur a déclenché une alerte via son mobile, mais un opérateur ne l'a pas encore prise en charge ou examinée.",
            "User triggered an alert via mobile, but an operator hasn't claimed/reviewed it yet.",
            "Orange",
            "Pulsing Warning"
    ),

    // 2. DISPATCH ACTIVE STAGES
    DISPATCHED(
            "Unités dépêchées",
            "Units Dispatched",
            "CRITICAL",
            "#00CFE8",
            "Unités d'intervention (Ambulance/Police/Pompiers) assignées, mais elles n'ont pas encore commencé à se déplacer.",
            "Responder units (Ambulance/Police/Fire) assigned, but haven't started moving.",
            "Cyan",
            "Solid Notice"
    ),
    ON_ROUTE(
            "En route",
            "En Route",
            "CRITICAL",
            "#1B9CFC",
            "Les secours se déplacent vers les coordonnées (état idéal pour démarrer la boucle de suivi de 5 secondes).",
            "Responders are moving toward coordinates (excellent state to start your 5s tracking loop).",
            "Blue",
            "Map Marker Tracking Live"
    ),
    ON_SITE(
            "Sur place",
            "On Site",
            "CRITICAL",
            "#95AFC0",
            "Les premiers secours sont arrivés sur le lieu des coordonnées de l'urgence.",
            "First responders arrived at the emergency coordinate location.",
            "Slate Grey",
            "Arrival Alert"
    ),

    // 3. MONITORING & MITIGATION
    ACTIVE(
            "Intervention en cours",
            "Incident Active",
            "CRITICAL",
            "#EA5455",
            "Le centre de contrôle ou les secours stabilisent activement ou gèrent l'incident de crise.",
            "Control center/responders actively stabilizing or working the crisis incident.",
            "Deep Red",
            "Maximum Urgency Flash"
    ),

    // 4. TERMINATION STATES
    RESOLVED(
            "Terminé",
            "Resolved",
            "LOW",
            "#28C76F",
            "L'appel s'est terminé en toute sécurité. Les cycles opérationnels sont correctement clôturés.",
            "Call wrapped up safely. Operational cycles closed cleanly.",
            "Bright Green",
            "Safe Checkmark"
    ),
    CANCELED(
            "Annulé",
            "Canceled",
            "LOW",
            "#4B5563",
            "L'appelant a annulé le ticket manuellement ou l'opérateur a rejeté le ticket immédiatement.",
            "Caller canceled the ticket manually or operator discarded the ticket immediately.",
            "Dark Grey",
            "Muted Text"
    ),
    FALSE_ALARM(
            "Fausse alerte",
            "False Alarm",
            "LOW",
            "#82868B",
            "Les unités sont arrivées sur place, mais il s'agissait d'un appui accidentel ou d'une notification vide. Utile pour les statistiques rapports.",
            "Units arrived, but it was an accidental press or empty notification. Valuable for reporting metrics.",
            "Light Grey",
            "Operational Archive"
    );

    private final String frenchDescription;
    private final String englishDescription;
    private final String severity;
    private final String color; // Hex string target representation
    private final String frenchUsageScenario;
    private final String englishUsageScenario;
    private final String colorHint;
    private final String uiPresentation;

    CallStatus(String frenchDescription,
               String englishDescription,
               String severity,
               String color,
               String frenchUsageScenario,
               String englishUsageScenario,
               String colorHint,
               String uiPresentation) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
        this.severity = severity;
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

    public static CallStatus getStatus(String statusString) {
        for (CallStatus status : CallStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid call status: " + statusString);
    }
}