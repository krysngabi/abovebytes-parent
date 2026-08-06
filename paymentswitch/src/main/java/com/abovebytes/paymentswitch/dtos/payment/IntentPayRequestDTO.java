package com.abovebytes.paymentswitch.dtos.payment;

import jakarta.validation.constraints.NotNull;

public record IntentPayRequestDTO(
        @NotNull(message = "payment.intent.id.required")
        String paymentIntentId,

        String paymentMethod,
        String stripeConnectedAccountId,

        boolean useStripeCard,
        boolean positiveTransaction,
        boolean isFromCentralApp
) {
        @Override
        public String toString() {
                return "IntentPayRequestDTO{" +
                        ", paymentIntentId='" + paymentIntentId + '\'' +
                        ", useStripeCard='" + useStripeCard + '\'' +
                        ", positiveTransaction='" + positiveTransaction + '\'' +
                        ", stripeConnectedAccountId='" + stripeConnectedAccountId + '\'' +
                        ", isFromCentralApp='" + isFromCentralApp + '\'' +
                        '}';
        }
}
