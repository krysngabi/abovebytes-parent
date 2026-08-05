package com.abovebytes.models.requests;

import com.abovebytes.enums.UserAuthTypeValue;
import com.abovebytes.utils.CommonUtils;

public record TaxPayLoginRequest(
        String password,
        String phone,
        String terminalId,
        UserAuthTypeValue userAuthType
) {
    public String getFormattedPhone() {
        return CommonUtils.removePlus(phone);
    }

    @Override
    public String toString() {
        return "TaxPayLoginRequest{" +
                "phone='" + phone + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", userAuthType=" + userAuthType +
                '}';
    }
}
