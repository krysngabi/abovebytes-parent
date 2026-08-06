package com.abovebytes.notifications.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class CentralAuthResponse extends BaseCentral {
    private String token;

    @Override
    public String toString() {
        return "CentralAuthResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}