package com.abovebytes.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonException extends RuntimeException {

    private final HttpStatus status;
    private final String code;
    private final String title;
    private final String message;
    private final String token;
    @Serial
    private static final long serialVersionUID = 1L;

    public CommonException(HttpStatus status, String message, String code) {
        super(message);
        this.message = message;
        this.status = status;
        this.code = code;
        this.token = null;
        this.title = null;
    }

    public CommonException(HttpStatus status, String message, String code, String title) {
        super(message);
        this.message = message;
        this.status = status;
        this.code = code;
        this.token = null;
        this.title = title;
    }

    public CommonException(HttpStatus status, String message, String code, String token, String title) {
        super(message);
        this.message = message;
        this.status = status;
        this.code = code;
        this.token = token;
        this.title = title;
    }
}
