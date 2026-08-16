package com.abovebytes.models.pymtswitch;

import com.abovebytes.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
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
@Schema(
        name = "PaymentIntentRequest",
        description = """
                Request used to create a Payment Intent.

                The request contains customer information, product details,
                payment amount, application context, and optional connected
                account information for Connect payments.
                """
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentIntentRequest {

    @Schema(
            description = "Name of the product or service being purchased.",
            example = "Premium Ride"
    )
    @NotBlank(message = "product.name.required")
    private String productName;

    @Schema(
            description = "Unique transaction identifier for the payment request. If not provided, the Payment Switch generates a UUID.",
            example = "550e8400-e29b-41d4-a716-446655440000"
    )
    @Nullable
    private String transactionId;

    @Schema(
            description = "Customer phone number in E.164 format.",
            example = "+15145551234",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "customer.phone.required")
    private String customerPhone;

    @Schema(
            description = "Customer full name.",
            example = "John Doe"
    )
    @NotBlank(message = "customer.name.required")
    private String customerName;

    @Schema(
            description = "ISO 4217 currency code.",
            example = "USD"
    )
    @NotBlank(message = "currency.code.required")
    private String currency;

    @Schema(
            description = "Payment amount expressed in the smallest currency unit (for example cents).",
            example = "2599",
            minimum = "1"
    )
    @NotNull(message = "amount.to.pay.required")
    @Min(value = 1, message = "amount.to.pay.greater.than.zero")
    private Long price;

    @Schema(
            description = "Internal product identifier.",
            example = "prod_001"
    )
    @NotNull(message = "product.id.required")
    private String productId;

    @Schema(
            description = "Internal user identifier originating from the calling application.",
            example = "USR-10001"
    )
    private String internalUserId; // internal.user.id.required

    @Schema(
            description = "Type of payment transaction.",
            implementation = TransactionType.class,
            example = "TOP_UP"
    )
    TransactionType transactionType;

    @Schema(
            description = "Previously stored payment card identifier.",
            example = "12"
    )
    Long cardId;

    @Schema(
            description = "Customer ISO-3166 country code.",
            example = "US"
    )
    @NotNull(message = "customer.country.code.required")
    private String customerCountryCode;

    @Schema(
            description = "Stripe Connected Account that should receive the payment.",
            example = "acct_1XX1HyAH89k"
    )
    private String stripeConnectedAccountId;

    @Schema(
            description = "Driver Stripe Connected Account used when splitting payments.",
            example = "acct_1ZaBcDeFgHiJkLmN"
    )
    private String driverConnectedAccountId;

    @Schema(
            description = "Name of the calling application.",
            allowableValues = {
                    "Central",
                    "CCPay"
            },
            example = "Central"
    )
    private String applicationName;

    @Schema(
            description = "Indicates whether the request originates from the Central application.",
            example = "true",
            defaultValue = "false"
    )
    private boolean isFromCentralApp;

    public PaymentIntentRequest withApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }

    public PaymentIntentRequest withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentIntentRequest{" +
                ", productId=" + productId +
                ", transactionId=" + transactionId +
                ", price=" + price +
                ", cardId=" + cardId +
                ", applicationName=" + applicationName +
                ", currency=" + currency +
                ", productName='" + productName + '\'' +
                ", customerName=" + customerName +
                ", customerPhone=" + customerPhone +
                ", productId=" + productId +
                ", internalUserId=" + internalUserId +
                ", customerCountryCode=" + customerCountryCode +
                ", stripeConnectedAccountId=" + stripeConnectedAccountId +
                ", driverConnectedAccountId=" + driverConnectedAccountId +
                ", isFromCentralApp=" + isFromCentralApp +
                '}'; //testing direct push
    }
}
