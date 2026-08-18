package com.abovebytes.paymentswitch.domain.constants;

import com.abovebytes.utils.constants.CommonQueryParamConstants;

public final class PaymentSwitchConstants {

    private PaymentSwitchConstants() {
    }


    public static final String REST_CONNECTION_TIMEOUT = "restTemplate.connectionTimeoutInSeconds";
    public static final String REST_READ_TIMEOUT = "restTemplate.readTimeoutInSeconds";
    public static final String MINIMUM_PAYMENT_USD = "MINIMUM_PAYMENT_USD";

    public static final String ONBOARDING = "/onboarding";
    public static final String STRIPE_URL_PREFIX = "/stripe";

    public static final String PAYMENT_SWITCH_FLAG = "X-AboveBytes-PaymentSwitch";
    public static final String STRIPE_PAYMENT_INTENT_SUCCEEDED = "succeeded";

    public static final int MAX_RETRIES = 3;
    public static final int RETRY_WAIT_IN_MILLISECONDS = 1000;

    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String LOCAL_PATH = "/api/paymentswitch/users/" + REFRESH_TOKEN;
    public static final String DEV_PATH = "/paymentswitch/users/" + REFRESH_TOKEN;
    public static final String TRACE_ID = "payment_switch_transaction_id";
    public static final String REFRESH_URI = "/users/" + REFRESH_TOKEN + "?" + CommonQueryParamConstants.LANG + "=";
    public static final String AUTH_URI = "/users/login?" + CommonQueryParamConstants.LANG + "=";

    public static String[] AUTHORIZED_PATHS = new String[] {
            "/actuator/health", "/stripe-webhooks/**", "/properties/stripe-publishable-key",
            "/users/login", "/users/refresh-token",
            "/swagger-resources/**", "/swagger-resources", "/configuration/ui",
            "/configuration/security", "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**", "/swagger-ui/**"};
}