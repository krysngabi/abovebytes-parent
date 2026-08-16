package com.abovebytes.models.pymtswitch;

import jakarta.validation.constraints.NotNull;

public record SavePaymentRegistrationRequest(
        String applicationName,

        String transactionId,

        @NotNull(message = "payment.intent.id.required")
        String paymentIntentId,

        @NotNull(message = "user.id.required")
        String internalAppCustomerId,

        String createdBy,

        @NotNull(message = "user.phone.required")
        String internalAppCustomerPhone,

        @NotNull(message = "amount.required")
        String amount,

        @NotNull(message = "status.required")
        String status,

        String lang
)  implements PaymentSwitchBaseRequest {

        public SavePaymentRegistrationRequest withRequired(
                String applicationName,
                String transactionId,
                String createdBy,
                String lang) {
                return new SavePaymentRegistrationRequest(
                        applicationName,
                        transactionId,
                        paymentIntentId,
                        internalAppCustomerId,
                        createdBy,
                        internalAppCustomerPhone,
                        amount,
                        status,
                        lang
                );
        }

        @Override
        public String toString() {
                return "SavePaymentRegistrationRequest{" +
                        ", applicationName='" + applicationName + '\'' +
                        ", transactionId='" + transactionId + '\'' +
                        ", lang='" + lang + '\'' +
                        ", paymentIntentId='" + paymentIntentId + '\'' +
                        ", internalAppCustomerId='" + internalAppCustomerId + '\'' +
                        ", internalAppCustomerPhone='" + internalAppCustomerPhone + '\'' +
                        ", createdBy='" + createdBy + '\'' +
                        ", amount='" + amount + '\'' +
                        ", status='" + status + '\'' +
                        '}';
        }
}
