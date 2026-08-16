package com.abovebytes.paymentswitch.domain.dtos.payment;

import com.abovebytes.models.pymtswitch.PaymentSwitchBaseRequest;
import jakarta.validation.constraints.NotNull;

public record PaymentIntentRequestDto(
        @NotNull(message = "application.name.required")
        String applicationName,

        String transactionId,

        @NotNull(message = "payment.intent.id.required")
        String paymentIntentId,

        String paymentMethod,
        String stripeConnectedAccountId,

        boolean useStripeCard,
        boolean positiveTransaction,
        boolean isFromCentralApp
) implements PaymentSwitchBaseRequest {

        public PaymentIntentRequestDto withTransactionId(String transactionId) {
                return new PaymentIntentRequestDto(
                        applicationName,
                        transactionId,
                        paymentIntentId,
                        paymentMethod,
                        stripeConnectedAccountId,
                        useStripeCard,
                        positiveTransaction,
                        isFromCentralApp
                );
        }

        @Override
        public String toString() {
                return "IntentPayRequestDTO{" +
                        ", applicationName='" + applicationName + '\'' +
                        ", transactionId='" + transactionId + '\'' +
                        ", paymentIntentId='" + paymentIntentId + '\'' +
                        ", useStripeCard='" + useStripeCard + '\'' +
                        ", positiveTransaction='" + positiveTransaction + '\'' +
                        ", stripeConnectedAccountId='" + stripeConnectedAccountId + '\'' +
                        ", isFromCentralApp='" + isFromCentralApp + '\'' +
                        '}';
        }
}
