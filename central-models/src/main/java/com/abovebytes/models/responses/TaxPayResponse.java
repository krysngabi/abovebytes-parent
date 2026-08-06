package com.abovebytes.models.responses;

import com.abovebytes.models.requests.TaxPayUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxPayResponse {
    private Integer errorCode;
    private boolean status;
    private Long paymentId;
    private Long maxiCashTimedResponseTime;
    private String message;
    private String declineReason;
    private String transactionId;
    private String mobileOperator;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private String savedPhone;
    private Long countryId;
    private final TaxPayUser user;

    public TaxPayResponse(String accessToken, String refreshToken, TaxPayUser user) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }
}