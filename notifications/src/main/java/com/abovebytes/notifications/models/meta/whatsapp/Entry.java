package com.abovebytes.notifications.models.meta.whatsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Entry {

    private String id;
    private List<Change> changes;

    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", changes=" + changes +
                '}';
    }
}