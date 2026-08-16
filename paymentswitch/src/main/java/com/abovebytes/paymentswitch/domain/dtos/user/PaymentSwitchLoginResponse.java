package com.abovebytes.paymentswitch.domain.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSwitchLoginResponse {

    @JsonProperty("applicationClient")
    private ApplicationClientDTO applicationClient;

    private String token;
    private String message;
    private boolean status;
}