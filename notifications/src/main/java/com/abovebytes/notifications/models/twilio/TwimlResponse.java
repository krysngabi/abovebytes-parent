package com.abovebytes.notifications.models.twilio;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@JacksonXmlRootElement(localName = "Response")
public class TwimlResponse {

    private Message Message;

    public TwimlResponse() {}

    public TwimlResponse(String body) {
        this.Message = new Message(body);
    }

    public Message getMessage() { return Message; }
    public void setMessage(Message message) { Message = message; }

    @Getter
    public static class Message {
        private String body;

        public Message(String body) {
            this.body = body;
        }

        public void setBody(String body) { this.body = body; }
    }
}
