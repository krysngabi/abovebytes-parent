package com.abovebytes.dtos.country;


import com.abovebytes.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CurrencyDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long currencyId;
    private String currencyCode;
    private String currencyName;
    private String currencySigle;
    private Status status;

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "currencyId=" + currencyId +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", currencySigle='" + currencySigle + '\'' +
                ", status=" + status +
                '}';
    }
}