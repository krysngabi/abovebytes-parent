package com.abovebytes.models.vendors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class MaxiCashResponse {

    @JsonProperty("SessionToken")
    private String sessionToken;

    @JsonProperty("ResponseStatus")
    private String responseStatus;

    @JsonProperty("ResponseError")
    private String responseError;

    @JsonProperty("ResponseData")
    private String responseData;

    @JsonProperty("ResponseDesc")
    private String responseDesc;

    @JsonProperty("TransactionID")
    private String transactionId;

    @JsonProperty("Reference")
    private String reference;

    public boolean isSuccess() {
        return "Success".equalsIgnoreCase(responseStatus);
    }

    @Override
    public String toString() {
        return "MaxiCashResponse { " +
                "sessionToken='" + sessionToken + '\'' +
                ", responseStatus='" + responseStatus + '\'' +
                ", responseError='" + responseError + '\'' +
                ", responseData='" + responseData + '\'' +
                ", responseDesc='" + responseDesc + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}