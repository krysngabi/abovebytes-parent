package com.abovebytes.notifications.models;

import jakarta.validation.constraints.NotNull;

public record CreateOrUpdateFeatureFlagRequest(
        CreateEnumRequest appName,

        @NotNull(message = "feature.flag.name.required")
        String name
) {


    @Override
    public String toString() {
        return "CreateOrUpdateFeatureFlagRequest{" +
                ", appName=" + appName +
                ", name=" + name +
                '}';
    }
}
