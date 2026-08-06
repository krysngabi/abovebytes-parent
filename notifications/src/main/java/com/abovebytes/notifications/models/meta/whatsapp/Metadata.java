package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Metadata {

    @JsonProperty("display_phone_number")
    private String displayPhoneNumber;

    @JsonProperty("phone_number_id")
    private String phoneNumberId;

    @Override
    public String toString() {
        return "Metadata{" +
                "displayPhoneNumber='" + displayPhoneNumber + '\'' +
                ", phoneNumberId='" + phoneNumberId + '\'' +
                '}';
    }
}