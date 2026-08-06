package com.abovebytes.paymentswitch.dtos.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AccountUpdateRequest(
        String newDisplayName,

        @NotNull(message = "connected.account.required")
        String stripeConnectedAccountId
) {
    @Override
    public String toString() {
        return "AccountUpdateRequest {" +
                " stripeConnectedAccountId='" + stripeConnectedAccountId + '\'' +
                "newDisplayName='" + newDisplayName + '\'' +
                '}';
    }
}
