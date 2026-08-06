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
public class Message {

    private String id;

    private String from;
    private String timestamp;
    private String type;

    private Text text;

    @JsonProperty("message_status")
    private String messageStatus;

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", text=" + text +
                ", messageStatus='" + messageStatus + '\'' +
                '}';
    }
}