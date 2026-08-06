package com.abovebytes.dtos.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentSearchDto {
    private Long id;
    private String denomination;
    private BigDecimal cost;
    private String currencyCode;
    private String currencySigle;
    private String documentCategory;
    private List<DocumentSearchDto> children;
}