package com.abovebytes.enums;

public enum ServiceCode {
    // --- Core First Responders ---
    POLICE_PHONE,        // Law enforcement / crime in progress
    AMBULANCE_PHONE,     // Medical emergencies
    POMPIER_PHONE,       // Fire and rescue (Pompier / Fire Brigade)

    // --- Specialized Rescue ---
    COAST_GUARD_PHONE,   // Maritime search and rescue
    MOUNTAIN_RESCUE,     // Wilderness / alpine emergency teams

    // --- Crisis & Social Infrastructure ---
    TRAFFIC_EMERGENCY,   // Road accidents / highway police
    ANTI_POISON_PHONE,   // Poison control centers
    MENTAL_HEALTH_HELP,  // Suicide prevention / psychiatric crisis
    CHILD_PROTECTION,    // Child abuse / missing children hotlines
    DOMESTIC_VIOLENCE,   // Immediate shelter / abuse support

    // --- Public Utility Hazards ---
    GAS_LEAK_PHONE,      // Natural gas line emergencies
    POWER_OUTAGE_PHONE;  // Downed power lines / electrical hazards

    /**
     * Checks if a given string matches any valid enum constant.
     */
    public static boolean isValid(String code) {
        if (code == null) return false;
        try {
            ServiceCode.valueOf(code.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static ServiceCode fromString(String value) {
        for (ServiceCode serviceCode : values()) {
            if (serviceCode.name().equalsIgnoreCase(value)) {
                return serviceCode;
            }
        }
        throw new IllegalArgumentException("Unknown service cpde: " + value);
    }
}