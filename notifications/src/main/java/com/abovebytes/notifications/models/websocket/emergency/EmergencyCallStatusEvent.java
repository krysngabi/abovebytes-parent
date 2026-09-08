package com.abovebytes.notifications.models.websocket.emergency;

import com.abovebytes.models.emergency.CallStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * Envelope published onto {@link com.abovebytes.notifications.constants.RabbitConstants#EMERGENCY_EXCHANGE}
 * with routing key {@link com.abovebytes.notifications.constants.RabbitConstants#EMERGENCY_CALL_STATUS_ROUTING_KEY}.
 * Carries the target user id so the notifications-service listener knows
 * which private user-queue to relay the payload to via
 * {@code convertAndSendToUser(userId, ...)}.
 */
@Getter
@Setter
public class EmergencyCallStatusEvent implements Serializable {

    private Long userId;
    private UUID emergencyCallId;

    private Long dispatcherId;
    private String dispatcherName;

    private CallStatus status;
    private Object payload;

    public EmergencyCallStatusEvent() {
        // required for Jackson deserialization on the consumer side
    }

    public EmergencyCallStatusEvent(Long userId, UUID emergencyCallId, Long dispatcherId, String dispatcherName, CallStatus status, Object payload) {
        this.userId = userId;
        this.emergencyCallId = emergencyCallId;
        this.dispatcherId = dispatcherId;
        this.dispatcherName = dispatcherName;
        this.status = status;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "EmergencyCallStatusEvent{" +
                "userId=" + userId +
                ", emergencyCallId=" + emergencyCallId +
                ", dispatcherId=" + dispatcherId +
                ", dispatcherName='" + dispatcherName + '\'' +
                ", status=" + status +
                ", payload=" + payload +
                '}';
    }
}