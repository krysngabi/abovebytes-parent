package com.abovebytes.paymentswitch.models.stripe;

public record StripeKeyResponse(
            String secretKey,
            boolean isTestMode
    ) {}