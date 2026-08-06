package com.abovebytes.notifications.models.websocket;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public record CleanUpQueueRequest(
        @NotNull(message = "queue.names.required")
        ArrayList<String> queueNames
) {

    @Override
    public String toString() {
        return "CleanUpQueueRequest {" +
                ", queueNames='" + queueNames + '\'' +
                '}';
    }
}
