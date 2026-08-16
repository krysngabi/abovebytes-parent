package com.abovebytes.utils;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {

    /**
     * Converts an amount from any currency to USD using a BigDecimal exchange rate.
     *
     * @param amount The amount in the original currency (e.g., CDF).
     * @param rateToUsd The rate of 1 unit = how many USD (e.g., for CDF: 0.00043765).
     * @return The converted value in USD, scaled to 2 decimals.
     */
    public static BigDecimal toUsd(BigDecimal amount, BigDecimal rateToUsd) {
        if (amount == null || rateToUsd == null) {
            throw new IllegalArgumentException("Amount and rate cannot be null");
        }

        // amount × rate = USD value
        return amount.multiply(rateToUsd).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal inverseRate(BigDecimal rate) {
        return BigDecimal.ONE
                .divide(rate, 2, RoundingMode.HALF_UP); // scale = 2 decimals
    }
}