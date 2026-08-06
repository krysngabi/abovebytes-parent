package com.abovebytes.models.pymtswitch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StripePaymentIntentRequest {

    @NotBlank(message = "product.name.required")
    private String productName;

    @NotBlank(message = "customer.phone.required")
    private String customerPhone;

    @NotBlank(message = "customer.name.required")
    private String customerName;

    @NotBlank(message = "currency.code.required")
    private String currency;

    @NotNull(message = "amount.to.pay.required")
    @Min(value = 1, message = "amount.to.pay.greater.than.zero")
    private Long price;

    @NotNull(message = "product.id.required")
    private String productId;

    @NotNull(message = "user.id.required")
    private String internalUserId;

    @NotNull(message = "customer.country.code.required")
    private String customerCountryCode;

    private String stripeConnectedAccountId;
    private String appName;
    private boolean isFromCentralApp;

    @Override
    public String toString() {
        return "StripePaymentIntentRequest{" +
                ", price=" + price +
                ", currency=" + currency +
                ", isFromCentralApp=" + isFromCentralApp +
                ", productName='" + productName + '\'' +
                ", customerName=" + customerName +
                ", customerPhone=" + customerPhone +
                ", productId=" + productId +
                ", internalUserId=" + internalUserId +
                ", customerCountryCode=" + customerCountryCode +
                ", stripeConnectedAccountId=" + stripeConnectedAccountId +
                '}'; //testing direct push
    }
}
