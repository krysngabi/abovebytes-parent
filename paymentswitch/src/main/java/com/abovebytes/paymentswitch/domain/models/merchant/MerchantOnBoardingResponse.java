package com.abovebytes.paymentswitch.domain.models.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class MerchantOnBoardingResponse {
    private String accountLinkUrl;
    private boolean status;
    private String message;
}