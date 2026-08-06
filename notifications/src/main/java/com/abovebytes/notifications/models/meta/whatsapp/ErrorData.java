package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@NoArgsConstructor
public class ErrorData {

    @JsonProperty("messaging_product")
    private String messagingProduct;

    private String details;

    @Override
    public String toString() {
        return "ErrorData{" +
                "messagingProduct='" + messagingProduct + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}