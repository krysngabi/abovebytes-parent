package com.abovebytes.models.pymtswitch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
// If ever you updating variables here make sure you check any api calling the switch ie central, ccpay,..
public class CostDto {
    Long finalGrossInCents;
    boolean sendTransactionsInUsd;
    Long cardId;
    String aboveBytesFeeBreakdown;
    BigDecimal minUSD, gross, stripeFeeChargeInPercentage, stripeFeeAddonInUsd, netAmountCalculated,
            rate, aboveBytesAggregatorFeeInPercentage, applicationFeeFromGross, stripeFeeFromGrossInCents, aboveBytesAggregatorFeeValue;
}