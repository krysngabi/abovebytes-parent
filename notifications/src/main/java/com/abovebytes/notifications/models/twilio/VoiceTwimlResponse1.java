package com.abovebytes.notifications.models.twilio;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "Response")
@Getter
@Setter
public class VoiceTwimlResponse1 {

    private Dial Dial;

    public VoiceTwimlResponse1() {}

    public VoiceTwimlResponse1(String phoneNumber) {
        this.Dial = new Dial(phoneNumber);
    }

    @Getter
    @Setter
    public static class Dial {

        @JacksonXmlText
        private String value;

        public Dial(String value) {
            this.value = value;
        }
    }
}