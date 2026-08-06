package com.abovebytes.paymentswitch.dtos.intents;

import java.util.ArrayList;

public class PaymentIntentList {
    public String object;
    public ArrayList<Datum> data;
    public boolean has_more;
    public String url;

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }
}