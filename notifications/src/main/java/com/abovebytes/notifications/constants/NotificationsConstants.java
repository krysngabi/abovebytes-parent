package com.abovebytes.notifications.constants;

import com.abovebytes.notifications.enums.OtpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NotificationsConstants {

    private NotificationsConstants() {
        // Prevent instantiation
    }

    public static final String localPath = "/api/notifications/users/refresh_token";
    public static final String devPath = "/notifications/users/refresh_token";
    public static final String APP_PROPERTIES_FILE = "notifications.properties";
    public static final String TRACE_ID = "notifications_req_transaction_id";
    public static final String WEBSOCKET_ENDPOINT = "/ws";
    public static final String SIMP_SESSION_ID = "simpSessionId";
    public static final String BROADCAST_APP_TOPIC = "/topic/broadcast/notifications";
    public static final String WS_DESTINATION = "/notifications-app-ws";
    public static final String CENTRAL_APP_NAME = "central-app-name";
    private static final String PAYMENT_STATUS_VALUE = "Paiement";
    public static final String SMTP_HOST = "smtp-host";
    public static final String DOCKER_CONTAINER_DOWN_TEMPLATE = "docker-container-down";
    public static final String FORGOT_PASSWORD_TEMPLATE = "forgot-password-";
    public static final String TEMP_PASSWORD_TEMPLATE = "temp-password-";
    public static final String DEFAULT_OTP_LENGTH = "6";
    public static final String DEFAULT_OTP_VALIDITY_MINUTES = "15";
    public static final String REST_CONNECTION_TIMEOUT = "restTemplate.connectionTimeoutInSeconds";
    public static final String REST_READ_TIMEOUT = "restTemplate.readTimeoutInSeconds";

    public static final Map<String, String> OPERATIONS_MAP = new HashMap<>();
    static{
        OPERATIONS_MAP.put("2", PAYMENT_STATUS_VALUE);
    }

    public static List<OtpStatus> ALLOWED_OTP_STATUSES = List.of(OtpStatus.ACTIVE, OtpStatus.DELIVERED, OtpStatus.READ);
    public static List<OtpStatus> NOT_EXPIRABLE_NEW_OTP_SENT = List.of(OtpStatus.VERIFIED, OtpStatus.EXPIRED);

    public static String[] AUTHORIZED_PATHS = new String[] {
            "/ws/**",
            "/users/login", "/authenticate", "/twilio/validate-otp", "/twilio/send-otp", "/meta/whatsapp/receive", "/meta/verify-otp",
            "/email/ccpay", "/twilio/receive/**", "/twilio/fallback", "/actuator/**", "/email/docker/container", "/email/central/forgot-password",
            "/email/central/temp-password",  "/properties/search-name", "/properties/search-app",
            "/swagger-resources/**", "/swagger-resources", "/configuration/ui",
            "/configuration/security", "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**", "/swagger-ui/**"};

}