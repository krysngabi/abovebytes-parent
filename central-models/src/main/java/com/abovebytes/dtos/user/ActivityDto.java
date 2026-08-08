package com.abovebytes.dtos.user;

import com.abovebytes.enums.ActivityStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String message;
    private boolean showForAll;
    private String activitySeverityColor;
    private ActivityStatus status;
    private String statusLabel;
    private LocalDateTime createDate;
    private String type;
    private String typeLabel;
    private String typeColor;
    private Long activityUserId;
    private Long habitationId;
    private boolean pinned;
    private LocalDateTime pinnedAt;
}
