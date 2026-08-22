package com.abovebytes.models.responses;

import com.abovebytes.dtos.featureflag.FeatureFlagDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppProperty {
    private boolean enforceStripeCheckoutScreen;
    private List<FeatureFlagDto> featureFlags;
    private String privacyPolicyFrench;
    private String privacyPolicyEnglish;
    private String termsAndConditionsFrench;
    private String termsAndConditionsEnglish;
    private String stripePublishableKey;
    private Integer otpCodeLength;
    private Integer otpMaxDurationSeconds;
    private Integer otpMaxAttempts;
    private String wsEmergencyUrl;
    private String wsEmergencyCallTopicPrefix;
}
