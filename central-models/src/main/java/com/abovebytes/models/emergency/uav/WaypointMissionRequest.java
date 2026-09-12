package com.abovebytes.models.emergency.uav;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record WaypointMissionRequest(
        @JsonProperty("missionId")
        String missionId,

        @JsonProperty("missionName")
        @NotEmpty
        String missionName,

        @JsonProperty("takeOffSecurityHeight")
        @NotNull
        @DecimalMin("1.2")
        @DecimalMax("1500")
        Double takeOffSecurityHeight,

        @JsonProperty("globalSpeed")
        @NotNull
        @DecimalMin("0.1")
        @DecimalMax("15.0")
        Double globalSpeed,

        @JsonProperty("finishAction")
        @NotNull
        MissionFinishAction finishAction,

        @JsonProperty("rcLostAction")
        @NotNull
        MissionRcLostAction rcLostAction,

        @JsonProperty("missionType")
        MissionPatternType missionType, // null/absent treated as CUSTOM

        @JsonProperty("pattern")
        @Valid
        PatternParams pattern, // required when missionType != CUSTOM

        @JsonProperty("perimeterInspection")
        @Valid
        PerimeterInspectionParams perimeterInspection,

        @JsonProperty("waypoints")
//        @NotEmpty
        List<@Valid WaypointRequest> waypoints
) {

    public record WaypointRequest(

            @NotNull
            @DecimalMin("-90")
            @DecimalMax("90")
            Double latitude,

            @NotNull
            @DecimalMin("-180")
            @DecimalMax("180")
            Double longitude,

            /*
             * Height relative to the takeoff point.
             */
            @NotNull
            @DecimalMin("1.2")
            @DecimalMax("1500")
            Double height,

            /*
             * Optional waypoint-specific speed.
             * null = use globalSpeed.
             */
            @DecimalMin("0.1")
            @DecimalMax("15.0")
            Double speed,

            /*
             * Aircraft heading in degrees.
             * 0 = North, 90 = East, 180 = South, 270 = West.
             */
            @DecimalMin("0")
            @DecimalMax("360")
            Double heading,

            /*
             * Gimbal pitch.
             * 0 = horizontal, negative values point downward.
             */
            @DecimalMin("-180")
            @DecimalMax("0")
            Double gimbalPitchAngle,

            List<@Valid WaypointActionRequest> actions
    ) {
    }

    public MissionPatternType resolvedType() {
        return missionType == null ? MissionPatternType.CUSTOM : missionType;
    }

    @AssertTrue(message = "waypoints/pattern/perimeterInspection must match missionType")
    private boolean isPayloadValid() {
        return switch (resolvedType()) {
            case CUSTOM -> waypoints != null && !waypoints.isEmpty();
            case SQUARE_PERIMETER, GRID_SURVEY, ORBIT -> pattern != null;
            case PERIMETER_INSPECTION -> perimeterInspection != null;
        };
    }

    public record WaypointActionRequest(

            @NotNull
            WaypointActionType type,

            /*
             * Used by gimbalRotate.
             */
            Double gimbalPitchAngle,

            /*
             * Used by gimbalRotate.
             */
            Double gimbalYawAngle,

            /*
             * Used by hover.
             */
            Double hoverTimeSeconds,

            /*
             * Optional filename suffix for takePhoto.
             */
            String fileSuffix
    ) {
    }

    public enum WaypointActionType {
        TAKE_PHOTO,
        START_RECORD,
        STOP_RECORD,
        GIMBAL_ROTATE,
        ROTATE_YAW,
        HOVER
    }

    public enum MissionFinishAction {
        GO_HOME,
        NO_ACTION,
        AUTO_LAND,
        GOTO_FIRST_WAYPOINT
    }

    public enum MissionRcLostAction {
        GO_CONTINUE,
        GO_BACK,
        LANDING,
        HOVER
    }
}