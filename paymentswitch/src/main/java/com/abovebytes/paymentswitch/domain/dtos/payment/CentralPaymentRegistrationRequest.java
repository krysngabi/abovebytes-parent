package com.abovebytes.paymentswitch.domain.dtos.payment;

import com.abovebytes.models.pymtswitch.PaymentSwitchBaseRequest;
import com.abovebytes.paymentswitch.domain.models.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;

public record CentralPaymentRegistrationRequest(
        @NotNull(message = "application.name.required")
        String applicationName,

        String transactionId,

        @NotNull(message = "payment.intent.id.required")
        String paymentIntentId,

        @NotNull(message = "customer.id.required")
        String internalAppCustomerId,

        @NotNull(message = "created.by.required")
        String createdBy,

        @NotNull(message = "customer.phone.required")
        String internalAppCustomerPhone,

        @NotNull(message = "amount.required")
        String amount,

        @NotNull(message = "status.required")
        PaymentStatus status,

        @NotNull(message = "lang.required")
        String lang
) implements PaymentSwitchBaseRequest {

        public CentralPaymentRegistrationRequest withTransactionId(String transactionId) {
                return new CentralPaymentRegistrationRequest(
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
                return "CentralPaymentRegistrationRequest{ " +
                        " applicationName='" + applicationName + '\'' +
                        " transactionId='" + transactionId + '\'' +
                        " lang='" + lang + '\'' +
                        ", paymentIntentId='" + paymentIntentId + '\'' +
                        ", internalAppCustomerId='" + internalAppCustomerId + '\'' +
                        ", internalAppCustomerPhone='" + internalAppCustomerPhone + '\'' +
                        ", amount='" + amount + '\'' +
                        ", status='" + status + '\'' +
                        '}';
        }
}
