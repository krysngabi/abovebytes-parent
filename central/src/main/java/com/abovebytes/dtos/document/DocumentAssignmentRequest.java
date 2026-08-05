package com.abovebytes.dtos.document;

import jakarta.validation.constraints.NotBlank;

public record DocumentAssignmentRequest(
        @NotBlank(message = "album.uid.required")
        String albumUid,

        @NotBlank(message = "document.type.required")
        String document,

        Long userId
) {
    @Override
    public String toString() {
        return "DocumentAssignmentRequest {" +
                "albumUid='" + albumUid + '\'' +
                ", userId='" + userId + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
