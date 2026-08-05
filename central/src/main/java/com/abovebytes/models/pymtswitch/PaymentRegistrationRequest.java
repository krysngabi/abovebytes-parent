package com.abovebytes.models.pymtswitch;

import jakarta.validation.constraints.NotNull;

public record PaymentRegistrationRequest(
        @NotNull(message = "payment.intent.id.required")
        String paymentIntentId,

        @NotNull(message = "user.id.required")
        String internalAppCustomerId,

        String createdBy,

        String modifiedBy,

        @NotNull(message = "user.phone.required")
        String internalAppCustomerPhone,

        @NotNull(message = "amount.required")
        String amount,

        @NotNull(message = "status.required")
        String status,

        String lang
) {
        public PaymentRegistrationRequest withCreatedBy(String createdBy, String lang) {
                return new PaymentRegistrationRequest(
                        paymentIntentId,
                        internalAppCustomerId,
                        createdBy,
                        modifiedBy,
                        internalAppCustomerPhone,
                        amount,
                        status,
                        lang
                );
        }

        @Override
        public String toString() {
                return "PaymentRegistrationRequest{" +
                        ", lang='" + lang + '\'' +
                        ", paymentIntentId='" + paymentIntentId + '\'' +
                        ", internalAppCustomerId='" + internalAppCustomerId + '\'' +
                        ", internalAppCustomerPhone='" + internalAppCustomerPhone + '\'' +
                        ", createdBy='" + createdBy + '\'' +
                        ", modifiedBy='" + modifiedBy + '\'' +
                        ", amount='" + amount + '\'' +
                        ", status='" + status + '\'' +
                        '}';
        }
}
