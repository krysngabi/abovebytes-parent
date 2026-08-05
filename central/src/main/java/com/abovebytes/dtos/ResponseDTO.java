package com.abovebytes.dtos;


import com.abovebytes.enums.ServiceCode;
import com.abovebytes.models.responses.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseDTO extends BaseResponse {
    private Long id;
    private UUID uuid;
    private String label;
    private BigDecimal amount;
    private String phonePrefix;
    private String value;
    private ServiceCode code;
    private String address;
    private String dataType;
    private String tempPassword;
    private String ownerName;
    LocalDateTime habitationCreationDate;
    private String ownerPhone;
    private int year;
    private String model;
    private String make;
    private String errorMessage;
}
