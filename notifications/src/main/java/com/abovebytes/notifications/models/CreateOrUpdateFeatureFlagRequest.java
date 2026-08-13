package com.abovebytes.notifications.models;

import com.abovebytes.models.CreateEnumRequest;
import jakarta.validation.constraints.NotNull;

public record CreateOrUpdateFeatureFlagRequest(
        CreateEnumRequest appName,

        @NotNull(message = "feature.flag.name.required")
        String name
) {


    @Override
    public String toString() {
        return "CreateOrUpdateFeatureFlagRequest{" +
                ", applicationName=" + appName +
                ", name=" + name +
                '}';
    }
}
