package com.abovebytes.notifications.models.websocket.emergency;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class EmergencyChatMessage {

    private UUID emergencyCallId;

    private Long senderId;

    private Long recipientId;

    private String senderType;

    private String message;

    private Instant timestamp;

    @Override
    public String toString() {
        return "EmergencyChatMessage{" +
                "emergencyCallId=" + emergencyCallId +
                ", senderId=" + senderId +
                ", recipientId=" + recipientId +
                ", senderType='" + senderType + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}