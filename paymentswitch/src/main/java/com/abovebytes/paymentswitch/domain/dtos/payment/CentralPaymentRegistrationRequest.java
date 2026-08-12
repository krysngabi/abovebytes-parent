package com.abovebytes.paymentswitch.domain.dtos.payment;

import com.abovebytes.paymentswitch.domain.models.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;

public record CentralPaymentRegistrationRequest(
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
        PaymentStatus status,

        @NotNull(message = "lang.required")
        String lang
) {
        @Override
        public String toString() {
                return "CentralPaymentRegistrationRequest{ " +
                        " lang='" + lang + '\'' +
                        ", paymentIntentId='" + paymentIntentId + '\'' +
                        ", internalAppCustomerId='" + internalAppCustomerId + '\'' +
                        ", internalAppCustomerPhone='" + internalAppCustomerPhone + '\'' +
                        ", amount='" + amount + '\'' +
                        ", status='" + status + '\'' +
                        '}';
        }
}
