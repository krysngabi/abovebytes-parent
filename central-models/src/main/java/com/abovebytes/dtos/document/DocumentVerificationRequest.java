package com.abovebytes.dtos.document;


import com.abovebytes.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DocumentVerificationRequest(
        /*
         * List of verified picture id.
         * This is used to verify the user based on the pictures they have uploaded.
         * Can be found by calling the endpoint to get all id pictures of a user with /id-documents
         */
        @NotNull(message = "verified.picture.id.required")
        Long verifiedPictureId,
        Status verificationStatus
) {

    @Override
    public String toString() {
        return "DocumentVerificationRequest {" +
                " verifiedPictureId='" + verifiedPictureId + '\'' +
                " verificationStatus='" + verificationStatus.name() + '\'' +
                '}';
    }
}