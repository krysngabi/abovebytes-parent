package com.abovebytes.notifications.models;

import jakarta.validation.constraints.NotBlank;

public record CreateEnumRequest(
        @NotBlank(message = "name.required")
        String name
) {}