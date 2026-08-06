package com.abovebytes.paymentswitch.dtos.payment;

import jakarta.validation.constraints.NotNull;

public record PaymentRegistrationRequest(
        @NotNull(message = "payment.intent.id.required")
        String paymentIntentId,

        @NotNull(message = "customer.id.required")
        String internalAppCustomerId,

        @NotNull(message = "created.by.required")
        String createdBy,

        String modifiedBy,

        @NotNull(message = "customer.phone.required")
        String internalAppCustomerPhone,

        @NotNull(message = "amount.required")
        String amount,

        @NotNull(message = "status.required")
        String status,

        @NotNull(message = "lang.required")
        String lang
) {
        @Override
        public String toString() {
                return "PaymentCreationDTO{ " +
                        " lang='" + lang + '\'' +
                        ", paymentIntentId='" + paymentIntentId + '\'' +
                        ", internalAppCustomerId='" + internalAppCustomerId + '\'' +
                        ", internalAppCustomerPhone='" + internalAppCustomerPhone + '\'' +
                        ", amount='" + amount + '\'' +
                        ", status='" + status + '\'' +
                        '}';
        }
}
