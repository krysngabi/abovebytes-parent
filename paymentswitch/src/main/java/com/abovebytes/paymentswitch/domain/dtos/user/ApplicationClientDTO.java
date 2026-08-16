package com.abovebytes.paymentswitch.domain.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationClientDTO {

    private Long id;
    private String clientId;
    private String clientName;
    private String clientEmail;
    private Long countryId;
    private String clientPhone;
    @JsonIgnore
    private String clientSecret;
    private String applicationName;
    private String status;
    private LocalDateTime lastConnection;
    @JsonIgnore
    private String refreshToken;
    private boolean refreshTokenRevoked;
    private List<String> roleNames;
}