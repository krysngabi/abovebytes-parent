package com.abovebytes.enums;

public enum ResponseMessage {
    SUCCESSFUL;

    public static ResponseMessage getStatus(String statusString) {
        for (ResponseMessage status : ResponseMessage.values()) {
            if (status.name().equalsIgnoreCase(statusString)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + statusString);
    }
}