package com.abovebytes.paymentswitch.domain.models.payments;

import com.abovebytes.paymentswitch.domain.models.enums.PaymentSwitchProvider;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ExchangeRateRequest(
        @NotBlank(message = "base.currency.code.required")
        String baseCurrencyCode,

        @NotBlank(message = "target.currency.code.required")
        String targetCurrencyCode,

        @NotNull(message = "rate.value.required")
        BigDecimal rate,

        PaymentSwitchProvider provider
) {
    @Override
    public String toString() {
        return "ExchangeRateRequest {" +
                "baseCurrencyCode='" + baseCurrencyCode + '\'' +
                "provider='" + provider + '\'' +
                ", targetCurrencyCode='" + targetCurrencyCode + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
