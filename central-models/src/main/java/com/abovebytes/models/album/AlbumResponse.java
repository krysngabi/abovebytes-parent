package com.abovebytes.models.album;

import lombok.Getter;

@Getter
public class AlbumResponse {
    String message;
    AlbumItem album;

    public AlbumResponse(String message, AlbumItem albumItem) {
        this.message = message;
        this.album = albumItem;
    }
}

