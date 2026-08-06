package com.abovebytes.models.album;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumContentResponse {

    private String message;
    private String name;
    private String description;
    private boolean isNsfw;
    private int count;
    private List<FileEntry> files;
}
