package com.abovebytes.paymentswitch.domain.models.payments;

import com.abovebytes.enums.TransactionType;
import com.abovebytes.paymentswitch.domain.models.enums.OperationType;
import com.abovebytes.paymentswitch.domain.models.enums.PaymentSwitchProvider;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentTransactionRequest(
        String driverTransferId,
        String merchantTransferId,

        @NotNull(message = "payment.provider.required")
        PaymentSwitchProvider provider,

        @NotNull(message = "operation.type.required")
        OperationType operationType,

        TransactionType transactionType,

        @NotBlank(message = "currency.code.required")
        String currencyCode,

        @NotBlank(message = "external.reference.id.required")
        String externalReferenceId,

        @NotBlank(message = "external.charge.id.required")
        String externalChargeId,

        @NotNull(message = "gross.amount.required")
        Long grossAmount,

        @NotNull(message = "gateway.fee.required")
        Long gatewaySwitchFee,

        @NotNull(message = "net.amount.required")
        Long netAmount,

        @NotNull(message = "platform.fee.required")
        Long platformFee,

        @NotNull(message = "merchant.payout.in.cents.required")
        Long merchantPayoutInCents,
        Long driverPayoutInCents,

        @NotNull(message = "merchant.account.id.required")
        String merchantAccountId,

        String driverAccountId,
        Long customerId,
        String paymentSwitchTxnId,
        String status,
        Long cardId,
        boolean isFromCentral

) {
    @Override
    public String toString() {
        return "PaymentTransactionRequest{" +
                ", driverTransferId='" + driverTransferId + '\'' +
                ", paymentSwitchTxnId='" + paymentSwitchTxnId + '\'' +
                ", isFromCentral='" + isFromCentral + '\'' +
                ", merchantTransferId='" + merchantTransferId + '\'' +
                ", provider=" + provider +
                ", customerId=" + customerId +
                ", operationType=" + operationType +
                ", transactionType='" + transactionType + '\'' +
                ", externalReferenceId='" + externalReferenceId + '\'' +
                ", externalChargeId='" + externalChargeId + '\'' +
                ", grossAmount=" + grossAmount +
                ", gatewaySwitchFee=" + gatewaySwitchFee +
                ", netAmount=" + netAmount +
                ", platformFee=" + platformFee +
                ", merchantPayoutInCents=" + merchantPayoutInCents +
                ", driverPayoutInCents=" + driverPayoutInCents +
                ", merchantAccountId='" + merchantAccountId + '\'' +
                ", driverAccountId='" + driverAccountId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
