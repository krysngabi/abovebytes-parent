package com.abovebytes.notifications.models;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {
    private String clientId;
    private String clientSecret;
}