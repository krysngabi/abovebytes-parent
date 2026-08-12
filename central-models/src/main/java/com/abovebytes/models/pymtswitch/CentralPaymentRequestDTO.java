package com.abovebytes.models.pymtswitch;

import com.abovebytes.enums.PaymentMode;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CentralPaymentRequestDTO(
        @NotNull(message = "user.id.required")
        Long centralAppUserId,

        @Nullable
        Long paymentId,

        Long documentRequestId,

        @Nullable
        String details,

        Long taxId,

        @NotBlank(message = "currency.code.required")
        String currencyCode,

        String clientPhoneNumber,
        String mobileOperator,

        @NotNull(message = "payment.mode.type.required")
        PaymentMode paymentModeType,

        String maxiCashReferenceId,
        String paymentStatus,
        String paymentIntentId,

        @NotNull(message = "amount.to.pay.required")
        BigDecimal amountToPay,

        @NotNull(message = "total.gross.amount.required")
        BigDecimal totalGrossAmount

) {
    @Override
    public String toString() {
        return "PaymentRequestDTO {" +
                "taxId=" + taxId +
                ", paymentId=" + paymentId +
                ", centralAppUserId=" + centralAppUserId +
                ", clientPhoneNumber=" + clientPhoneNumber +
                ", paymentModeType=" + paymentModeType +
                ", mobileOperator=" + mobileOperator +
                ", totalGrossAmount=" + totalGrossAmount +
                ", amountToPay=" + amountToPay +
                '}';
    }
}
