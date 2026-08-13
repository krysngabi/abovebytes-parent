package com.abovebytes.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtils {

    @Value("${spring.profiles.active:local}")
    private String activeProfile;

    public ResponseCookie refreshTokenCookie(String refreshToken, long refreshTokenExpiration, String localPath, String devPath) {
        boolean isLocal = activeProfile.equalsIgnoreCase("local");

        String path = isLocal ? localPath : devPath;

        return ResponseCookie.from("refresh_token", refreshToken)
                .httpOnly(true)
                .secure(!isLocal) // Secure = false for local, true for dev/prod
                .path(path)
                .sameSite(isLocal ? "Lax" : "Strict") // Lax for local so Postman/browser can send it
                .maxAge(refreshTokenExpiration * 60)
                .build();
    }
}
