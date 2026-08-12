package com.abovebytes.paymentswitch.domain.dtos.payment;

import lombok.Builder;

@Builder
public class PaymentMetadataDTO {
    private String customerName;
    private String customerId;
    private String customerCountryCode;
    private String productId;
    private String productName;
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
}