package com.abovebytes.notifications.models.twilio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwilioVerificationResponse {

    @JsonProperty("account_sid")
    private String accountSid;

    private String amount;

    private String channel;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("date_updated")
    private String dateUpdated;

    private Lookup lookup;

    private String payee;

    @JsonProperty("send_code_attempts")
    private List<SendCodeAttempt> sendCodeAttempts;

    @JsonProperty("service_sid")
    private String serviceSid;

    private String sid;

    private String status;

    private String to;

    private String url;

    @JsonIgnore
    private boolean valid;

    @Data
    public static class Lookup {
        private String carrier;
    }

    @Data
    public static class SendCodeAttempt {
        @JsonProperty("attempt_sid")
        private String attemptSid;
        
        private String channel;
        
        private String time;
    }
}