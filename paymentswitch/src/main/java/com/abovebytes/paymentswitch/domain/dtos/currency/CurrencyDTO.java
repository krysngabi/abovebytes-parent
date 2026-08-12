package com.abovebytes.paymentswitch.domain.dtos.currency;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyDTO {
    private Long id;
    private String symbol;
    private String code;
    private String name;
}
