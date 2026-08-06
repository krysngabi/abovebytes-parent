package com.abovebytes.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlbumRequest(
        @NotBlank(message = "album.name.required")
        String name,

        @NotNull(message = "album.document.category.required")
        String albumDocumentCategory,

        Long townshipId
) {
    @Override
    public String toString() {
        return "AlbumRequest {" +
                "name='" + name + '\'' +
                ", townshipId='" + townshipId + '\'' +
                ", albumDocumentCategory='" + albumDocumentCategory + '\'' +
                '}';
    }
}
