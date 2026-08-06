package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    private String id;

    private String status;

    private String timestamp;

    private Pricing pricing;

    @JsonProperty("recipient_id")
    private String recipientId;

    private List<ErrorData> errors;

    @Override
    public String toString() {
        return "Status{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", recipientId='" + recipientId + '\'' +
                ", errors=" + errors +
                ", pricing=" + pricing +
                '}';
    }
}