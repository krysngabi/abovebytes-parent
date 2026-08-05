package com.abovebytes.models.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError<T> {

    private String code;
    private String token;
    private String message;
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private T content;
    private String title;
    private String transactionId;
    private Long paymentId;
    private Object details;
}

