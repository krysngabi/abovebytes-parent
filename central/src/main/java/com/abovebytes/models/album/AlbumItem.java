package com.abovebytes.models.album;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class AlbumItem {
    String uuid;
    String name;
}
