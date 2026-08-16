package com.abovebytes.paymentswitch.domain.models.payments;

import com.abovebytes.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TopUpDebitRequest(
        @NotNull(message = "card.id.required")
        Long cardId,

        @NotNull(message = "txn.id.required")
        String paymentSwitchTxnId,

        @NotNull(message = "top.up.amount.required")
        @Min(value = 1, message = "top.up.must.be.greater.than.zero")
        BigDecimal amount,

        @NotNull(message = "transaction.type.required")
        TransactionType transactionType
) {

    @Override
    public String toString() {
        return "TopUpDebitRequest {" +
                " cardId='" + cardId + '\'' +
                ", amount='" + amount + '\'' +
                " paymentSwitchTxnId='" + paymentSwitchTxnId + '\'' +
                " transactionType='" + transactionType + '\'' +
                '}';
    }
}