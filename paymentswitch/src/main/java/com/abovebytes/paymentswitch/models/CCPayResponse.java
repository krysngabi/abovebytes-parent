package com.abovebytes.paymentswitch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CCPayResponse {
    private Integer errorCode;
    private boolean status;
    private String message;
    private String token;
    private String refreshToken;

    public CCPayResponse(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }
}