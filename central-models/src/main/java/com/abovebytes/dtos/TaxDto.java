package com.abovebytes.dtos;

import com.abovebytes.enums.TaxStatus;
import com.abovebytes.enums.TaxValueType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxDto {
    private Long id;
    private String denomination;
    private BigDecimal value;
    private BigDecimal minTaxValueUsd;
    private BigDecimal maxTaxValueUsd;
    private BigDecimal minTaxValueCdf;
    private BigDecimal maxTaxValueCdf;
    private TaxValueType taxValueType;
    private TaxStatus status;
    private String currencyCode;
    private List<TaxDto> children;
}