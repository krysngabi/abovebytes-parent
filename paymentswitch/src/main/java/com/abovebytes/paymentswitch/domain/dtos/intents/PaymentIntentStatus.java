package com.abovebytes.paymentswitch.domain.dtos.intents;

import lombok.Data;

import java.util.Date;
@Data
public class PaymentIntentStatus {
    private String intentId;
    private String status;
    private Date statusDate;
    private String cancellationReason;

    public PaymentIntentStatus(String intentId, String status, Date statusDate, String cancellationReason) {
        this.intentId = intentId;
        this.status = status;
        this.statusDate = statusDate;
        this.cancellationReason = cancellationReason;
    }
}
