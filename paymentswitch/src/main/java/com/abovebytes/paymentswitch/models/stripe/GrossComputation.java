package com.abovebytes.paymentswitch.models.stripe;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class GrossComputation {
    private final BigDecimal grossUsd;   // Gross amount in USD
    private final BigDecimal grossCents; // Gross amount in cents
}
