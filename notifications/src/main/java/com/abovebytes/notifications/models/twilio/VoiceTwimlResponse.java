package com.abovebytes.notifications.models.twilio;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Response")
public class VoiceTwimlResponse {

    @JacksonXmlProperty(localName = "Say")
    private Say say;

    @JacksonXmlProperty(localName = "Record")
    private Record record;

    public VoiceTwimlResponse() {}

    public VoiceTwimlResponse(String message, String voice, String lang, String recordingCallbackUrl) {
        this.say = new Say(message, voice, lang); // ✅ correct
        this.record = new Record(recordingCallbackUrl);
    }

    // ---- SAY ----
    @Getter
    @Setter
    public static class Say {

        @JacksonXmlProperty(isAttribute = true)
        private String voice;

        @JacksonXmlProperty(isAttribute = true)
        private String language;

        @JacksonXmlText
        private String value;

        public Say(String value, String voice, String language) {
            this.value = value;
            this.voice = voice;
            this.language = language;
        }
    }

    // ---- RECORD ----
    @Getter
    @Setter
    public static class Record {

        @JacksonXmlProperty(isAttribute = true)
        private int maxLength = 30;

        @JacksonXmlProperty(isAttribute = true)
        private String action;

        public Record(String action) {
            this.action = action;
        }
    }
}