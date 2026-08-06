package com.abovebytes.paymentswitch.models.enums;

import lombok.Getter;

@Getter
public enum PayoutPreference {
    IMMEDIATE,
    STANDARD,
    SCHEDULED;
}