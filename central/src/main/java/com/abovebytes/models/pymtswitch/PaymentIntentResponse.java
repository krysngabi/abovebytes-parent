package com.abovebytes.models.pymtswitch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
// If ever you updating variables here make sure you check with the payment switch naming
public class PaymentIntentResponse {
    private String clientSecret;
    private String customerId;
    private String productId;
    private String paymentIntentId;
    private CostDto costDto;
}