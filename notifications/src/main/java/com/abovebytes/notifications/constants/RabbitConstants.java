package com.abovebytes.notifications.constants;

import java.util.List;

/**
 * RabbitMQ topology constants for the emergency call broadcast pipeline.
 * Central publishes onto {@link #EMERGENCY_EXCHANGE} using {@link #EMERGENCY_CALL_ROUTING_KEY};
 * the notification service binds {@link #EMERGENCY_CALL_QUEUE} to that exchange/key and consumes from it.
 */
public final class RabbitConstants {
    public static final String EMERGENCY_EXCHANGE = "emergency.exchange";
    public static final String EMERGENCY_CALL_QUEUE = "emergency.call.broadcast.queue";
    public static final String EMERGENCY_CALL_ROUTING_KEY = "emergency.call.broadcast";
    public static final String EMERGENCY_CALL_DLQ = "emergency.call.broadcast.dlq";
    public static final String EMERGENCY_CALL_DLX = "emergency.call.broadcast.dlx";
    public static final String EMERGENCY_CALL_ASSIGNED_ROUTING_KEY = "emergency.call.assigned";
    public static final String EMERGENCY_CALL_ASSIGNED_QUEUE =
            "emergency.call.assigned.queue";

    public static final String EMERGENCY_CALL_ASSIGNED_TOPIC =
            "/topic/emergency.dispatcher.assigned";
    public static final String WEBSOCKET_ENDPOINT = "/ws";
    public static final String SIMP_SESSION_ID = "simpSessionId";
    public static final String EMERGENCY_CALL_WAITING_TOPIC =  "/topic/emergency.call.dispatcher.waiting";
    public static final String BROADCAST_APP_TOPIC = "/topic/broadcast.notifications";
    public static final String WS_DESTINATION = "/notifications-app-ws";
    public static final String WS_HEARTBEAT = "ws-heartbeat-";
    // These are the ONLY two destination prefixes the RabbitMQ relay will accept.
    // Any message whose destination doesn't start with one of these gets rejected
    // by the broker with "Invalid destination" — this is exactly what happened
    // when convertAndSendToUser() rewrote a destination in a way that dropped
    // the leading prefix (see explanation below).
    public static final String RELAY_TOPIC_PREFIX = "/topic";
    public static final String RELAY_QUEUE_PREFIX = "/queue";
    public static final String USER_DESTINATION_PREFIX = "/user";
    public static final List<String> RELAY_DESTINATION_PREFIXES = List.of(
            RELAY_TOPIC_PREFIX,
            RELAY_QUEUE_PREFIX
    );

    private RabbitConstants() {}
}