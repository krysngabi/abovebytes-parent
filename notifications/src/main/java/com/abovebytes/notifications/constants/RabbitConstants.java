package com.abovebytes.notifications.constants;

import java.util.List;

/**
 * RabbitMQ topology constants for the emergency call broadcast pipeline.
 * Central publishes onto {@link #EMERGENCY_EXCHANGE} using {@link #EMERGENCY_CALL_ROUTING_KEY};
 * the notification service binds {@link #EMERGENCY_CALL_QUEUE} to that exchange/key and consumes from it.
 */
public final class RabbitConstants {
    /**
     * Name of the topic exchange used to route all emergency-call-related
     * messages (broadcast, assigned, etc.) to their respective bound queues.
     */
    public static final String EMERGENCY_EXCHANGE = "emergency.exchange";

    /**
     * Queue that receives newly registered emergency calls before any
     * dispatcher has claimed them. Consumed by
     * {@code EmergencyCallListener#handleEmergencyCallBroadcast} and relayed
     * to dispatchers via {@link #EMERGENCY_CALL_WAITING_TOPIC}.
     */
    public static final String EMERGENCY_CALL_QUEUE = "emergency.call.broadcast.queue";

    /**
     * Routing key used to publish a newly registered emergency call to
     * {@link #EMERGENCY_EXCHANGE}, binding to {@link #EMERGENCY_CALL_QUEUE}.
     */
    public static final String EMERGENCY_CALL_ROUTING_KEY = "emergency.call.broadcast";

    /**
     * Dead-letter queue for {@link #EMERGENCY_CALL_QUEUE}. Messages that
     * cannot be processed after retries are routed here (via
     * {@link #EMERGENCY_CALL_DLX}) so failures remain visible and
     * reprocessable instead of being silently lost.
     */
    public static final String EMERGENCY_CALL_DLQ = "emergency.call.broadcast.dlq";

    /**
     * Dead-letter exchange associated with {@link #EMERGENCY_CALL_QUEUE}.
     * Failed messages are routed through this exchange into
     * {@link #EMERGENCY_CALL_DLQ}.
     */
    public static final String EMERGENCY_CALL_DLX = "emergency.call.broadcast.dlx";

    /**
     * Routing key used to publish an emergency call assignment event to
     * {@link #EMERGENCY_EXCHANGE}, binding to {@link #EMERGENCY_CALL_ASSIGNED_QUEUE}.
     */
    public static final String EMERGENCY_CALL_ASSIGNED_ROUTING_KEY = "emergency.call.assigned";

    /**
     * Queue that receives emergency call assignment events once a dispatcher
     * successfully claims a call. Consumed by
     * {@code EmergencyCallListener#handleAssigned} and relayed to connected
     * clients via {@link #EMERGENCY_CALL_ASSIGNED_TOPIC}.
     */
    public static final String EMERGENCY_CALL_ASSIGNED_QUEUE =
            "emergency.call.assigned.queue";

    /**
     * STOMP destination that dispatcher clients subscribe to in order to be
     * notified in real time when an emergency call is assigned to a
     * dispatcher.
     */
    public static final String EMERGENCY_CALL_ASSIGNED_TOPIC =
            "/topic/emergency.dispatcher.assigned";

    /**
     * Path Spring registers the STOMP-over-WebSocket endpoint on, used by
     * clients to establish the initial WebSocket handshake/connection.
     */
    public static final String WEBSOCKET_ENDPOINT = "/ws";

    /**
     * Key under which the current STOMP/WebSocket session identifier is
     * stored in the simp session attributes map, used to correlate a
     * connected client's messages back to its session.
     */
    public static final String SIMP_SESSION_ID = "simpSessionId";

    /**
     * STOMP destination that dispatcher clients subscribe to in order to
     * be notified in real time when a new, unclaimed emergency call is
     * registered and awaiting assignment.
     */
    public static final String EMERGENCY_CALL_WAITING_TOPIC =  "/topic/emergency.call.dispatcher.waiting";

    /**
     * General-purpose STOMP destination used to broadcast application-wide
     * notifications to all connected clients, independent of any specific
     * emergency call.
     */
    public static final String BROADCAST_APP_TOPIC = "/topic/broadcast.notifications";

    /**
     * Path Spring registers the notifications app's STOMP-over-WebSocket
     * endpoint on, used by clients to establish the initial connection for
     * the notifications app.
     */
    public static final String WS_DESTINATION = "/notifications-app-ws";

    /**
     * Prefix used when constructing a per-session heartbeat identifier
     * (e.g. combined with a session ID) to track and manage WebSocket
     * keep-alive heartbeats for an individual connected client.
     */
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