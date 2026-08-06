package com.abovebytes.models.album;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileEntry {
    private String name;
    private String createdAt;
    private String ip;
    private String original;
    private String uuid;
    private String hash;
    private long size;
    private String type;
    private String url;
    private String thumb;
    private String preview;
}
