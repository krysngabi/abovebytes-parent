package com.abovebytes.paymentswitch.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntegrationAppsErrorDTO {
    private String path;
    private String code;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "IntegrationAppsErrorDTO{" +
                "path='" + path + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
