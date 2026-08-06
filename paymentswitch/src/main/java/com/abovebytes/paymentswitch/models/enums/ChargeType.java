package com.abovebytes.paymentswitch.models.enums;

import lombok.Getter;

@Getter
public enum ChargeType {
    /**
     * Direct Charge
     *  - The customer is charged directly on the merchant’s account.
     *  - Money goes directly to the merchant.
     *  - Your platform (the "platform account") can still take an application fee if you want.
     *  - You don’t need to use TransferData.destination.
     *   =====================================================================================
     *  Flow
     *  Customer -> Merchant Account (Stripe) -> Merchant gets money
     *             |-> Platform collects fee (optional)
     * When to use:
     *  - If the merchant is the main “seller” and you only want to take a platform fee.
     */
    DIRECT,
    /**
     * Destination Charge
     *  - The customer is charged on your platform account.
     *  - Stripe automatically transfers funds to the connected account (merchant) using TransferData.destination.
     *  - You can charge an application fee for your platform.
     *  Flow
     *  Customer -> Platform Account (Stripe) -> Transfer to Merchant Account
     *             |-> Platform collects fee
     *  ===========================================================================================================
     *  - The payment is first received by the platform.
     *  - You control the payment and can deduct fees before sending to the merchant.
     *  - You must set TransferData.destination in PaymentIntent
     */
    DESTINATION
}