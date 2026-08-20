package com.abovebytes.models.emergency;

import com.abovebytes.models.responses.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmergencyResponse extends BaseResponse {
    private UUID emergencyCallId;
    private String requestSignature;
    private String senderId;
    private LocalDateTime createdAt;
    private ArrayList<String> failedQueues;
}