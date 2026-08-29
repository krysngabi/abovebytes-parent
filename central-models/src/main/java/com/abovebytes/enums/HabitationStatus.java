package com.abovebytes.enums;

import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Enum representing the possible lifecycle statuses of a habitation, along with
 * their localized descriptions, severity levels, and UI display colors.
 */
@Getter
public enum HabitationStatus {

    REGISTERED("Enregistré", "Registered", Severity.NEUTRAL, "#6B7280"),
    UNCLAIMED("Non revendiqué", "Unclaimed", Severity.LOW, "#EAB308"),
    PENDING_VERIFICATION("En attente de vérification", "Pending Verification", Severity.MEDIUM, "#F97316"),
    ACTIVE("Actif", "Active", Severity.LOW, "#22C55E"),
    UNDER_REVIEW("En cours d'examen", "Under Review", Severity.MEDIUM, "#8B5CF6"),
    FLAGGED("Signalé", "Flagged", Severity.HIGH, "#EF4444"),
    SUSPENDED("Suspendu", "Suspended", Severity.CRITICAL, "#B91C1C"),
    VACATED("Inoccupé", "Vacated", Severity.LOW, "#0EA5E9"),
    DECOMMISSIONED("Radié", "Decommissioned", Severity.NEUTRAL, "#4B5563"),
    ARCHIVED("Archivé", "Archived", Severity.NEUTRAL, "#9CA3AF"),
    DELETED("Effacé", "Deleted", Severity.CRITICAL, "#FF0000");


    private final String frenchDescription;
    private final String englishDescription;
    private final Severity severity;
    private final String color;

    HabitationStatus(String frenchDescription, String englishDescription, Severity severity, String color) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
        this.severity = severity;
        this.color = color;
    }

    public enum Severity {
        NEUTRAL,
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }

    private static final Map<String, HabitationStatus> LOOKUP_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(status -> status.name().toUpperCase(), Function.identity()));

    /**
     * Resolves the localized description based on the current LocaleContext.
     */
    public String getDescription() {
        if ("en".equalsIgnoreCase(LocaleContextHolder.getLocale().getLanguage())) {
            return this.englishDescription;
        }
        return this.frenchDescription;
    }

    /**
     * Retrieves a HabitationStatus by string name (case-insensitive).
     *
     * @param statusString String representation of the status
     * @return Matching HabitationStatus
     * @throws IllegalArgumentException if no match is found
     */
    public static HabitationStatus getStatus(String statusString) {
        return Optional.ofNullable(statusString)
                .map(String::trim)
                .map(String::toUpperCase)
                .map(LOOKUP_MAP::get)
                .orElseThrow(() -> new IllegalArgumentException("Invalid habitation status: " + statusString));
    }
}