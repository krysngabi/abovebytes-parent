package com.abovebytes.paymentswitch.domain.models.stripe;

public record StripeKeyResponse(
            String secretKey,
            boolean isTestMode
    ) {}