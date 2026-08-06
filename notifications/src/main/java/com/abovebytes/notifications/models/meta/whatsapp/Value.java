package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Value {

    @JsonProperty("messaging_product")
    private String messagingProduct;

    private Metadata metadata;
    private List<Contact> contacts;
    private List<Message> messages;
    private List<Status> statuses;

    @Override
    public String toString() {
        return "Value{" +
                "messagingProduct='" + messagingProduct + '\'' +
                ", metadata=" + metadata +
                ", contacts=" + contacts +
                ", messages=" + messages +
                ", statuses=" + statuses +
                '}';
    }

    // getters/setters
}