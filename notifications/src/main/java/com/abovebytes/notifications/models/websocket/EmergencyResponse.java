package com.abovebytes.notifications.models.websocket;

import com.abovebytes.notifications.models.BaseResponse;
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
    private String senderId;
    private Long dispatcherId;
    private String dispatcherName;
    private LocalDateTime createdAt;
    private String requestSignature;
    private ArrayList<String> failedQueues;
}