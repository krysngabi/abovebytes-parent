package com.abovebytes.models.pymtswitch;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentRequestDTO(
        @NotNull(message = "tax.id.required")
        Long taxId,

        Long posId,

        @Nullable
        Long paymentId,

        boolean isACentralAppPayment,
        Long centralAppUserId,

        @NotBlank(message = "currency.sigle.required")
        String currencySigle,

        String clientPhoneNumber,
        String mobileOperator,

        @NotNull(message = "payment.mode.type.required")
        String paymentModeType,

        String referenceId,

        @NotNull(message = "paid.amount.required")
        BigDecimal paidAmount,

        BigDecimal totalGrossAmount,

        @NotNull(message = "payment.status.required")
        String paymentStatus,

        @NotNull(message = "payment.category.required")
        String paymentCategory

) {
    @Override
    public String toString() {
        return "PaymentRequestDTO {" +
                "taxId=" + taxId +
                ", paymentId=" + paymentId +
                ", isACentralAppPayment=" + isACentralAppPayment +
                ", centralAppUserId=" + centralAppUserId +
                ", clientPhoneNumber=" + clientPhoneNumber +
                ", paymentModeType=" + paymentModeType +
                ", mobileOperator=" + mobileOperator +
                ", totalGrossAmount=" + totalGrossAmount +
                ", paidAmount=" + paidAmount +
                ", paymentStatus=" + paymentStatus +
                ", paymentCategory=" + paymentCategory +
                '}';
    }
}
