package com.abovebytes.notifications.models.websocket;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

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
    private Object payload;

    public EmergencyCallStatusEvent() {
        // required for Jackson deserialization on the consumer side
    }

    public EmergencyCallStatusEvent(Long userId, Object payload) {
        this.userId = userId;
        this.payload = payload;
    }
}