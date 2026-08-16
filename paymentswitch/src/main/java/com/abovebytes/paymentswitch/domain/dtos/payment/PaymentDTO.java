package com.abovebytes.paymentswitch.domain.dtos.payment;

import com.abovebytes.paymentswitch.domain.models.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PaymentDTO")
public class PaymentDTO {

    private Long paymentId;

    private String paymentIntentId;

    private String internalAppCustomerId;

    private String internalAgentId;

    private String internalAppCustomerPhone;

    private String customerName;

    private String productName;

    private String amount;

    private PaymentStatus paymentStatus;

    private LocalDateTime createDate;

    private LocalDateTime lastModified;

    private String customerId;

    private String customerCountryCode;

    private String productId;

    private String requestedProductId;

    private String requestedAmount;

    private String requestedCurrency;

    private String grossAmount;

    private String exchangeRate;

    private String providerFees;

    private String aboveBytesFee;

    private String aboveBytesFeeBreakdown;

    private String totalAppFeeAmountCents;

    private String switchTransactionId;

    private Boolean fromCentral;

    private Integer errorCode;
    private Long timedResponseTime;
    private String message;
    private String declineReason;
    private String transactionId;
}