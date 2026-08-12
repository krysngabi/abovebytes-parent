package com.abovebytes.paymentswitch.domain.models.enums;

import lombok.Getter;

@Getter
public enum PayoutPreference {
    IMMEDIATE,
    STANDARD,
    SCHEDULED;
}