package com.abovebytes.paymentswitch.domain.constants;

public final class PaymentMetadataConstants {

    private PaymentMetadataConstants() {
    }

    // -------------------------------------------------------------------------
    // Stripe PaymentIntent Metadata Keys
    // -------------------------------------------------------------------------

    public static final String CUSTOMER_NAME = "customer_name";
    public static final String CUSTOMER_ID = "customer_id";
    public static final String CUSTOMER_COUNTRY_CODE = "customer_country_code";
    public static final String INTERNAL_USER_ID = "internal_user_id";

    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_NAME = "product_name";
    public static final String REQUEST_PRODUCT_ID = "req_product_id";

    public static final String REQUEST_AMOUNT = "req_amount";
    public static final String REQUEST_CURRENCY = "req_currency";
    public static final String GROSS_AMOUNT = "gross";
    public static final String EXCHANGE_RATE = "exchange_rate";

    public static final String PROVIDER_FEES = "provider_fees";
    public static final String ABOVE_BYTES_PLATFORM_FEE = "above_bytes_fee";
    public static final String ABOVE_BYTES_FEE_BREAKDOWN = "above_bytes_fee_breakdown";
    public static final String TOTAL_APP_FEE_AMOUNT_CENTS = "total_app_fee_amount_cents";

    public static final String SWITCH_TRANSACTION_ID = "switch_transaction_id";
    public static final String IS_FROM_CENTRAL = "is_from_central";

    public static final String DRIVER_ACCOUNT_ID = "driver_account_id";
    public static final String MERCHANT_ACCOUNT_ID = "merchant_account_id";
    public static final String CCPAY_MERCHANT_OR_USER_ID = "ccpay_merchant_or_user_id";
    public static final String CCPAY_CARD_ID = "ccpay_card_id";
    public static final String TRANSACTION_TYPE = "transaction_type";
    public static final String STRIPE_PAYMENT_INTENT_SUCCEEDED = "succeeded";

    public static final String MINIMUM_PAYMENT_USD = "MINIMUM_PAYMENT_USD";
}