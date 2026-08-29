package com.abovebytes.notifications.constants;

import java.util.List;

/**
 * RabbitMQ topology constants for the emergency call broadcast pipeline.
 * Central publishes onto {@link #EMERGENCY_EXCHANGE} using {@link #EMERGENCY_CALL_ROUTING_KEY};
 * the notification service binds {@link #EMERGENCY_CALL_QUEUE} to that exchange/key and consumes from it.
 */
public final class RabbitConstants {
    public static final String USER_DESTINATION_PREFIX = "/user";

    /**
     * Name of the topic exchange used to route all emergency-call-related
     * messages (broadcast, assigned, etc.) to their respective bound queues.
     */
    public static final String EMERGENCY_EXCHANGE = "emergency.exchange";

    /**
     * Prefix for the per-call STOMP destination used to broadcast live
     * tracking updates (e.g. location, running status) for a specific
     * emergency call. The full destination is formed by appending the
     * emergency call's UUID directly to this prefix, e.g.
     * {@code EMERGENCY_CALL_TRACK_TOPIC_PREFIX + emergencyCallId} ->
     * {@code "/topic/dispatcher.track.emergency.call.0cf50bcf-05af-440f-92bf-2ed824c0b982"}.
     * Dispatcher clients subscribe to the resolved destination to receive
     * real-time tracking updates for that specific call only.
     */
//    webSocketService.publishToDestination(
//    RabbitConstants.EMERGENCY_CALL_TRACK_TOPIC_PREFIX + emergencyCallId,
//    trackingPayload);
    public static final String EMERGENCY_CALL_TRACK_TOPIC_PREFIX = "/topic/dispatcher.track.emergency.call.";

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
     * Dead-letter exchange associated with {@link #EMERGENCY_CALL_STATUS_QUEUE}.
     */
    public static final String EMERGENCY_CALL_STATUS_DLX = "emergency.call.status.dlx";

    /**
     * Dead-letter queue for {@link #EMERGENCY_CALL_STATUS_QUEUE}. Messages that
     * cannot be processed after retries (e.g. malformed payload, unresolvable
     * userId, relay rejection) are routed here via {@link #EMERGENCY_CALL_STATUS_DLX}
     * so per-citizen status update failures remain visible and reprocessable
     * instead of being silently lost.
     */
    public static final String EMERGENCY_CALL_STATUS_DLQ = "emergency.call.status.dlq";

    /**
     * STOMP destination that dispatcher clients subscribe to in order to be
     * notified in real time when an emergency call is assigned to a
     * dispatcher.
     */
    public static final String EMERGENCY_CALL_ASSIGNED_TOPIC =
            "/topic/emergency.call.dispatcher.assigned";

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
     * Routing key used to publish a per-citizen emergency call status update
     * (e.g. "your call was assigned") to {@link #EMERGENCY_EXCHANGE}, bound to
     * {@link #EMERGENCY_CALL_STATUS_QUEUE}. Unlike {@link #EMERGENCY_CALL_ASSIGNED_ROUTING_KEY},
     * this is intended for exactly one recipient — the citizen who placed the
     * call — not a dispatcher broadcast.
     */
    public static final String EMERGENCY_CALL_STATUS_ROUTING_KEY = "emergency.call.status";

    /**
     * Queue that receives per-citizen call status update events. Consumed by
     * {@code EmergencyCallListener#handleCallStatusUpdate}, which resolves the
     * target user id from the payload and relays it privately via
     * {@code convertAndSendToUser(userId, EMERGENCY_CALL_STATUS_QUEUE_SUFFIX, payload)}.
     */
    public static final String EMERGENCY_CALL_STATUS_QUEUE = "emergency.call.status.queue";

    /**
     * Destination suffix passed as the second argument to
     * {@code convertAndSendToUser(...)}. MUST start with {@link #RELAY_QUEUE_PREFIX}
     * ("/queue") — Spring's UserDestinationMessageHandler prepends "/user/{userId}"
     * internally and resolves the whole thing down to a session-scoped
     * "/queue/..." destination before handing it to the broker relay. This is
     * the exact class of bug noted above {@link #RELAY_DESTINATION_PREFIXES}:
     * if this constant were missing its leading slash, or a bare string like
     * "queue/emergency-call-status" were passed instead, the resolved
     * destination would lose the "/queue" prefix the relay checks for and
     * RabbitMQ's STOMP adapter would reject it with "Invalid destination".
     * Clients subscribe to "/user/queue/emergency-call-status" — never to this
     * constant's literal value directly.
     */
    public static final String EMERGENCY_CALL_STATUS_QUEUE_SUFFIX = "/queue/emergency-call-status";

    /**
     * Fully-resolved STOMP destination string that clients (citizen app) must
     * subscribe to in order to receive their own per-call status updates —
     * {@code "/user" + EMERGENCY_CALL_STATUS_QUEUE_SUFFIX}, i.e.
     * {@code "/user/queue/emergency-call-status"}.
     * <p>
     * This is distinct from {@link #EMERGENCY_CALL_STATUS_QUEUE_SUFFIX}, which is
     * the value passed server-side as the destination argument to
     * {@code convertAndSendToUser(userId, EMERGENCY_CALL_STATUS_QUEUE_SUFFIX, payload)}.
     * The {@link #USER_DESTINATION_PREFIX} ("/user") is a marker Spring's
     * {@code UserDestinationMessageHandler} strips and rewrites internally on
     * the sending side, but clients must include it literally when subscribing —
     * the two sides of this flow use different strings by design, not by
     * accident.
     * <p>
     * Exposing this precomputed constant (e.g. via app config served to the
     * Flutter client as {@code wsEmergencyCallStatusQueue}) avoids each side
     * hand-typing and potentially drifting out of sync with
     * {@link #EMERGENCY_CALL_STATUS_QUEUE_SUFFIX} — if the suffix ever changes,
     * this constant changes with it automatically.
     */
    public static final String CLIENT_EMERGENCY_CALL_STATUS_DESTINATION =
            USER_DESTINATION_PREFIX + EMERGENCY_CALL_STATUS_QUEUE_SUFFIX; // "/user/queue/emergency-call-status"

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
    public static final List<String> RELAY_DESTINATION_PREFIXES = List.of(
            RELAY_TOPIC_PREFIX,
            RELAY_QUEUE_PREFIX
    );
    private RabbitConstants() {}
}