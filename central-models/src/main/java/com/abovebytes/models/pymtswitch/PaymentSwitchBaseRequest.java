package com.abovebytes.models.pymtswitch;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public interface PaymentSwitchBaseRequest {
        @Nullable
        String transactionId();

        @NotNull(message = "application.name.required")
        String applicationName();
}