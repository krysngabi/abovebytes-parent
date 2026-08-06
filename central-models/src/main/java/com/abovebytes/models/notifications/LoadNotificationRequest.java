package com.abovebytes.models.notifications;

import com.abovebytes.enums.PerformanceSize;
import com.abovebytes.enums.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record LoadNotificationRequest(
        @NotNull(message = "receiver.id.required")
        Long receiverId,

        Long loadCount,

        @NotNull(message = "message.length.required")
        Long messageLength,

        @NotNull(message = "random.senders.count.required")
        Long numberOfRandomSenders,

        @NotNull(message = "expiration.in.hours.required")
        @Min(message = "expiration.greater.than.zero", value = 1L)
        @Max(message = "expiration.exceeded", value = 72L)
        Long expirationInHours,

        @NotNull(message = "status.required")
        Status status,

        PerformanceSize performanceSize
) {
    @Override
    public String toString() {
        return "LoadNotificationRequest {" +
                ", receiverId='" + receiverId + '\'' +
                ", loadCount=" + loadCount +
                ", status=" + status +
                ", messageLength=" + messageLength +
                ", expirationInHours=" + expirationInHours +
                ", numberOfRandomSenders=" + numberOfRandomSenders +
                ", performanceSize=" + performanceSize +
                '}';
    }
}
