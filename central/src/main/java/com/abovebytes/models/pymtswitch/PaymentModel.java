package com.abovebytes.models.pymtswitch;

import lombok.Data;

@Data
public class PaymentModel {
    private String cardNumber;
    private String cardPin;
    private String currency_id;
    private String amount;
    private String merchant_curr_id;
    private String merchant_id;
    private String merchant_card_id;
}
