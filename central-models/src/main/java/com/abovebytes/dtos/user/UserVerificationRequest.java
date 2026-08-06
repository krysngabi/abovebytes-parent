package com.abovebytes.dtos.user;

import com.abovebytes.dtos.document.DocumentVerificationRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserVerificationRequest(
        @NotNull(message = "user.id.required")
        Long userId,

        /*
         * List of verified picture ids.
         * This is used to verify the user based on the pictures they have uploaded.
         * Can be found by calling the endpoint to get all id pictures of a user with /id-documents
         */
        @NotNull(message = "verified.picture.ids.required")
        List<DocumentVerificationRequest> documentVerificationRequests,
        boolean denyIdVerification,
        String denyIdVerificationReason
) {

    @Override
    public String toString() {
        return "UserVerificationRequest {" +
                " userId='" + userId + '\'' +
                " denyIdVerification='" + denyIdVerification + '\'' +
                " denyIdVerificationReason='" + denyIdVerificationReason + '\'' +
                ", documentVerificationRequests=" + (documentVerificationRequests == null || documentVerificationRequests.isEmpty() ? "No verified id documents d provided" : Arrays.toString(documentVerificationRequests.toArray())) +
                '}';
    }
}