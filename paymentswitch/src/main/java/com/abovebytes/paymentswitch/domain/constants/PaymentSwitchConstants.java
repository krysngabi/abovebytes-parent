package com.abovebytes.paymentswitch.domain.constants;

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
}