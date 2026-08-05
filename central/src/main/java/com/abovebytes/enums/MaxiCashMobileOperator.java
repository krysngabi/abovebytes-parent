package com.abovebytes.enums;

import com.abovebytes.exceptions.CommonException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MaxiCashMobileOperator {
    AIRTEL_MONEY(1, "Airtel Money"),
    M_PESA(2, "M pesa"),
    ORANGE_MONEY(3, "Orange Money"),
    AFRI_MONEY(51, "Afri Money");

    private final int operatorId;
    private final String description;

    MaxiCashMobileOperator(int operatorId, String description) {
        this.operatorId = operatorId;
        this.description = description;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static MaxiCashMobileOperator fromString(String value) {
        for (MaxiCashMobileOperator mobileOperator : MaxiCashMobileOperator.values()) {
            if (mobileOperator.name().equalsIgnoreCase(value)) {
                return mobileOperator;
            }
        }
        String validValues = String.join(", ",
                java.util.Arrays.stream(MaxiCashMobileOperator.values())
                        .map(MaxiCashMobileOperator::getDescription)
                        .toArray(String[]::new)
        );

        throw new CommonException(
                HttpStatus.BAD_REQUEST,
                "The mobile operator " + value + " is invalid. Valid values are " + validValues,
                "400"
        );
    }

    public static MaxiCashMobileOperator retrieveFromString(String value) {
        for (MaxiCashMobileOperator mobileOperator : MaxiCashMobileOperator.values()) {
            if (mobileOperator.name().equalsIgnoreCase(value)) {
                return mobileOperator;
            }
        }

        return null;
    }

    public static MaxiCashMobileOperator fromOperatorId(int operatorId) {
        for (MaxiCashMobileOperator operator : values()) {
            if (operator.getOperatorId() == operatorId) {
                return operator;
            }
        }

        throw new CommonException(
                HttpStatus.BAD_REQUEST,
                "L'identifiant de l'opérateur mobile " + operatorId + " est invalide.",
                "400"
        );
    }
}