package com.abovebytes.paymentswitch.domain.dtos.merchant;

import com.abovebytes.paymentswitch.domain.models.enums.ChargeType;
import com.abovebytes.paymentswitch.domain.models.enums.EnvironmentMode;
import com.abovebytes.paymentswitch.domain.models.enums.MerchantType;
import com.abovebytes.paymentswitch.domain.models.enums.PayoutPreference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OnboardingRequest(
        // ISO 3166-1 alpha-2 or ISO 2-letter code
        @NotBlank(message = "country.code.required")
        String countryCode,

        @NotBlank(message = "display.name.required")
        String displayName,

        @NotBlank(message = "admin.firstname.required")
        String adminFirstName,

        @NotBlank(message = "admin.lastname.required")
        String adminLastName,

        @NotNull(message = "charge.type.required")
        ChargeType chargeType,

        @NotNull(message = "merchant.type.required")
        MerchantType merchantType,

        @NotNull(message = "payout.preference.required")
        PayoutPreference payoutPreference,

        @NotNull(message = "environment.mode.required")
        EnvironmentMode runningMode,
        BigDecimal platformPercentage,

        @NotBlank(message = "merchant.website.required")
        @Pattern(
                regexp = "^(https?://)?(www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$",
                message = "invalid.website.format"
        )
        String merchantWebSite,

        String refreshUrl,

        String returnUrl,

        @NotNull(message = "ccpay.merchant.id.required")
        Long CCPAYMerchantIdOrUserId,

        @NotNull(message = "account.default.currency.id.required")
        Long defaultAccountCurrencyId,

        String businessDescription,

        @NotBlank(message = "merchant.email.required")
        @Email(message = "invalid.email")
        @Pattern(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$", message = "invalid.email")
        String merchantEmail
) {
    @Override
    public String toString() {
        return "MerchantOnboardingReq {" +
                "countryCode='" + countryCode + '\'' +
                "displayName='" + displayName + '\'' +
                "merchantEmail='" + merchantEmail + '\'' +
                "merchantWebSite='" + merchantWebSite + '\'' +
                "merchantWebSite='" + merchantWebSite + '\'' +
                "businessDescription='" + businessDescription + '\'' +
                "CCPAYMerchantIdOrUserId='" + CCPAYMerchantIdOrUserId + '\'' +
                "defaultAccountCurrencyId='" + defaultAccountCurrencyId + '\'' +
                '}';
    }
}
