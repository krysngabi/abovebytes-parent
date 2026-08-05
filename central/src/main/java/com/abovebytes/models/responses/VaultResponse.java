package com.abovebytes.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VaultResponse extends BaseResponse {
    private String id;
    private String signature;
    private String title;
    private String token;
    private Boolean requestVerified = null;
    private String cipherText;
    private Object decipheredData;
}