package com.abovebytes.models;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientAuthenticationRequest implements Serializable {
    private String clientId;
    private String clientSecret;
}