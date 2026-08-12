package com.abovebytes.paymentswitch.domain.constants;

public final class QueryParamConstants {

    private QueryParamConstants() {
        // Prevent instantiation
    }

    public static final String STRIPE_CONNECTED_ACCOUNT_ID = "stripeConnectedAccountId";
    public static final String CUSTOMER_ID = "customerId";
    public static final String PAGE = "page";
    public static final String SIZE = "size";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
}