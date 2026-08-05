package com.abovebytes.enums;

import lombok.Getter;

@Getter
public enum PlaceStatus {
    OPEN("Ouvert", "Open"),
    PENDING_REVIEW("En attente de révision", "Pending Review"),
    CLOSED("Fermé", "Closed"),
    UNDER_RENOVATION("En rénovation", "Under Renovation"),
    TEMPORARILY_CLOSED("Fermé temporairement", "Temporarily Closed"),
    PERMANENTLY_CLOSED("Fermé définitivement", "Permanently Closed");

    private final String frenchDescription;
    private final String englishDescription;

    PlaceStatus(String frenchDescription, String englishDescription) {
        this.frenchDescription = frenchDescription;
        this.englishDescription = englishDescription;
    }

    // Method to retrieve the PlaceStatus from a string representation
    public static PlaceStatus getStatus(String statusString) {
        for (PlaceStatus status : PlaceStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid place status: " + statusString);
    }
}
