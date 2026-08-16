package com.abovebytes.paymentswitch.domain.utils;


import com.abovebytes.paymentswitch.domain.constants.QueryParamConstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentSwitchUtils {

    /**
     * Builds a deterministic, pipe-delimited canonical string payload for signature verification.
     * Null values are normalized to empty strings to avoid signing literal "null" text.
     *
     * @param applicationName the name of the application making the request
     * @param transactionId the transaction ID associated with the search (optional)
     * @param customerId the ID of the customer associated with the search (optional)
     * @param stripeConnectedAccountId the Stripe connected account ID (optional)
     * @param startDate the start date for filtering (optional)
     * @param endDate the end date for filtering (optional)
     * @param page the zero-based page index for pagination
     * @param size the page size for pagination
     * @return the pipe-delimited canonical payload string
     */
    public static String buildCanonicalPayload(
            String applicationName,
            String transactionId,
            String customerId,
            String stripeConnectedAccountId,
            LocalDateTime startDate,
            LocalDateTime endDate,
            int page,
            int size
    ) {
        return String.format("%s|%s|%s|%s|%s|%s|%d|%d",
                nullToEmpty(applicationName),
                nullToEmpty(transactionId),
                nullToEmpty(customerId),
                nullToEmpty(stripeConnectedAccountId),
                startDate != null ? startDate.format(DateTimeFormatter.ofPattern(QueryParamConstants.DATE_TIME_FORMAT)) : "",
                endDate != null ? endDate.format(DateTimeFormatter.ofPattern(QueryParamConstants.DATE_TIME_FORMAT)) : "",
                page,
                size
        );
    }

    private static String nullToEmpty(String input) {
        return input != null ? input : "";
    }
}
