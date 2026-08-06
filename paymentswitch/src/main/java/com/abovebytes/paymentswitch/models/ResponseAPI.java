package com.abovebytes.paymentswitch.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAPI {

    private boolean status = false;
    private String message;
    private String errorCode;
}
