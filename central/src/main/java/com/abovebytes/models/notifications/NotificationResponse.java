package com.abovebytes.models.notifications;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class NotificationResponse {
    private Integer unreadCount;
}
