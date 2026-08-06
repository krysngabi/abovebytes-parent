package com.abovebytes.notifications.models;


import com.abovebytes.notifications.enums.OtpChannel;
import com.abovebytes.notifications.enums.OtpLimitInterval;
import jakarta.validation.constraints.NotNull;

public record AddOtpLimitRuleRequest(
        @NotNull(message = "app.name.required")
        CreateEnumRequest appName,

        @NotNull(message = "channel.required")
        OtpChannel channel,

        @NotNull(message = "interval.type.required")
        OtpLimitInterval intervalType,

        Integer intervalValue,

        @NotNull(message = "max.requests.required")
        int maxRequests
) {


    @Override
    public String toString() {
        return "AddOtpLimitRuleRequest{" +
                ", appName=" + appName +
                ", channel=" + channel +
                ", intervalType=" + intervalType +
                ", intervalValue=" + intervalValue +
                ", maxRequests=" + maxRequests +
                '}';
    }
}
