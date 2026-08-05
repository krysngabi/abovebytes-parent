package com.abovebytes.models.statuses;


public enum TestStatus {
    ENABLED,
    DISABLED;

    public static TestStatus getStatus(String statusString) {
        for (TestStatus status : TestStatus.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + statusString);
    }
}