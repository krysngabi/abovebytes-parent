package com.abovebytes.notifications.models.websocket.emergency;

import com.abovebytes.models.emergency.CallPriority;
import com.abovebytes.models.emergency.CallStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmergencyCallBroadcastDTO implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "emergency.call.id.required")
    private UUID emergencyCallId;

    @NotNull(message = "emergency.call.status.required")
    private CallStatus callStatus;

    @NotNull(message = "emergency.call.priority.required")
    private CallPriority priorityLevel;

    @NotNull(message = "emergency.call.latitude.required")
    private BigDecimal latitude;

    @NotNull(message = "emergency.call.longitude.required")
    private BigDecimal longitude;

    @NotNull(message = "emergency.call.service.name.required")
    private String serviceName;

    @NotNull(message = "emergency.call.caller.phone.required")
    private String callerPhone;

    @NotNull(message = "emergency.call.caller.name.required")
    private String callerName;

    @NotNull(message = "emergency.call.date.required")
    private String createdAt;

    private Long dispatcherId;
    private String dispatcherName;

    @NotNull(message = "emergency.call.caller.user.id.required")
    private Long callerUserId;
}