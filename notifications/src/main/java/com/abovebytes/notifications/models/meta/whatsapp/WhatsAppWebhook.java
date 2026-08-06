package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WhatsAppWebhook {

    private String object;
    private List<Entry> entry;

    @Override
    public String toString() {
        return "WhatsAppWebhook{" +
                "object='" + object + '\'' +
                ", entry=" + entry +
                '}';
    }
}