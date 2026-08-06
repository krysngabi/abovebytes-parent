package com.abovebytes.models.requests;

import com.abovebytes.utils.CommonUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginRequest(
        @NotBlank(message = "password.required")
        @Size(min = 4, message = "password.should.have.at.least.4.characters")
        String password,

        @NotBlank(message = "phone.number.required")
        String phone,

        Boolean biometricAuthentication,
        String pushToken,
        String deviceId,
        String deviceType,
        String deviceInfo
) {
    public String getFormattedPhone() {
        return CommonUtils.removePlus(phone);
    }

    public UserLoginRequest {
        if (biometricAuthentication == null) {
            biometricAuthentication = false; // or true, whatever the sensible default is
        }
    }

    @Override
    public String toString() {
        return "UserLoginRequest {" +
                " phone='" + phone + '\'' +
                " deviceId='" + deviceId + '\'' +
                " deviceType='" + deviceType + '\'' +
                " deviceInfo='" + deviceInfo + '\'' +
                " pushToken='" + pushToken + '\'' +
                " biometricAuthentication='" + biometricAuthentication + '\'' +
                '}';
    }
}
