package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    private Profile profile;
    private String input;

    @JsonProperty("wa_id")
    private String waId;

    @Override
    public String toString() {
        return "Contact{" +
                "profile=" + profile +
                ", input='" + input + '\'' +
                ", waId='" + waId + '\'' +
                '}';
    }

    // getters and setters
}