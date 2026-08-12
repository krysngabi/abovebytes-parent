package com.abovebytes.paymentswitch.domain.dtos.intents;

import java.util.ArrayList;

public class Datum {
    public String id;
    public String object;
    public int amount;
    public int amount_capturable;
    public AmountDetails amount_details;
    public int amount_received;
    public Object application;
    public Object application_fee_amount;
    public Object automatic_payment_methods;
    public int canceled_at;
    public String cancellation_reason;
    public String capture_method;
    public String client_secret;
    public String confirmation_method;
    public int created;
    public String currency;
    public Object customer;
    public Object description;
    public Object invoice;
    public Object last_payment_error;
    public Object latest_charge;
    public boolean livemode;
    public Metadata metadata;
    public Object next_action;
    public Object on_behalf_of;
    public Object payment_method;
    public PaymentMethodOptions payment_method_options;
    public ArrayList<String> payment_method_types;
    public Object processing;
    public Object receipt_email;
    public Object review;
    public Object setup_future_usage;
    public Object shipping;
    public Object source;
    public Object statement_descriptor;
    public Object statement_descriptor_suffix;
    public String status;
    public Object transfer_data;
    public Object transfer_group;
}