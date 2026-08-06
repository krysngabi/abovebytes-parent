package com.abovebytes.notifications.models.central;

import com.abovebytes.notifications.models.BaseCentral;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApi extends BaseCentral {
    private Long userId;
    private String displayName;
    private String status;
    private HabitationDTO userHabitation;
    private String phone;

    @Override
    public String toString() {
        return "UserApi{" +
                "userId=" + userId +
                ", displayName='" + displayName + '\'' +
                ", status='" + status + '\'' +
                ", userHabitation=" + userHabitation +
                ", phone='" + phone + '\'' +
                '}';
    }
}
