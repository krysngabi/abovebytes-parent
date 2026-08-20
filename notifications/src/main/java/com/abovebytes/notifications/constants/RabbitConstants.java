package com.abovebytes.notifications.constants;

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
    public static final String WEBSOCKET_ENDPOINT = "/ws";
    public static final String SIMP_SESSION_ID = "simpSessionId";
    public static final String EMERGENCY_CALL_WAITING_TOPIC = "/topic/emergency/dispatcher.waiting";
    public static final String BROADCAST_APP_TOPIC = "/topic/broadcast/notifications";
    public static final String WS_DESTINATION = "/notifications-app-ws";

    private RabbitConstants() {}
}