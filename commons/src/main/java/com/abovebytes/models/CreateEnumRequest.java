package com.abovebytes.models;

import jakarta.validation.constraints.NotBlank;

public record CreateEnumRequest(
        @NotBlank(message = "name.required")
        String name
) {}