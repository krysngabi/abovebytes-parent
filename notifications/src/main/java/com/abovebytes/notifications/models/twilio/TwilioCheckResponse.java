package com.abovebytes.notifications.models.twilio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwilioCheckResponse {

    @JsonProperty("account_sid")
    private String accountSid;

    private String amount;

    private String channel;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("date_updated")
    private String dateUpdated;

    private String payee;

    @JsonProperty("service_sid")
    private String serviceSid;

    private String sid;

    private String status;

    private String to;

    @JsonIgnore
    private boolean valid;
}