package com.abovebytes.paymentswitch.domain.dtos.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class StripeDto {
    private final String stripePublishableKey;
    private final String loginLink;
}