package com.abovebytes.dtos.country;


import com.abovebytes.enums.Status;
import com.abovebytes.models.exceptions.ApiError;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CountryDTO extends ApiError<Void> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String label;
    private String code;
    private String timeZone;
    private String phonePrefix;
    private Status status;
    private CurrencyDTO currency;
}
