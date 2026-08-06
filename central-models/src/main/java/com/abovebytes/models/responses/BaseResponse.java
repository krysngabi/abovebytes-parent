package com.abovebytes.models.responses;


import com.abovebytes.models.emergency.CallStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {
    @JsonProperty("status")
    private boolean status;
    private CallStatus callStatus;
    private String message;
}