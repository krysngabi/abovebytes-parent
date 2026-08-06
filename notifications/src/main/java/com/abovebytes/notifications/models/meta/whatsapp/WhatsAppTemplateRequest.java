package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhatsAppTemplateRequest {

    @JsonProperty("messaging_product")
    private String messagingProduct = "whatsapp";

    private String to;
    private String type = "template";
    private Template template;
    private Text text;

    // getters/setters
}