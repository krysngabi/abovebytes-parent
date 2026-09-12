package com.abovebytes.models.emergency.uav;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Parameters for a {@link MissionPatternType#PERIMETER_INSPECTION} mission:
 * a diamond-shaped loop around a center point, visiting exactly four
 * corners (north, east, south, west) with per-corner height, speed,
 * gimbal, and action overrides — plus an optional video recording
 * bookend that starts at the first corner and stops at a closing
 * waypoint back at the takeoff point.
 * <p>
 * Unlike {@link PatternParams}, which assumes uniform behavior across
 * every stop, this pattern is built specifically to reproduce inspection
 * flights where the aircraft climbs for a roof pass and descends again —
 * i.e. missions like the reference "Building Perimeter Inspection" flight,
 * where each corner has genuinely different height/gimbal/action needs.
 *
 * @param centerLatitude    Latitude of the perimeter's center point.
 * @param centerLongitude   Longitude of the perimeter's center point.
 * @param radiusMeters      Distance from center to each corner, in meters.
 * @param globalSpeedFallback Speed used for any corner that doesn't specify its own.
 * @param corners           Exactly 4 entries, in order: north, east, south, west.
 * @param startRecording    If true, attaches {@code START_RECORD} to the first corner.
 * @param stopRecording     If true, attaches {@code STOP_RECORD} to the closing waypoint.
 * @param closingHeight     Height for the closing waypoint back at center (recommended
 *                           lower than the corners, as a final descent before landing).
 * @param closingHoverSeconds Optional hover duration at the closing waypoint.
 */
public record PerimeterInspectionParams(
        @NotNull Double centerLatitude,
        @NotNull Double centerLongitude,
        @NotNull @DecimalMin("1") Double radiusMeters,
        Double globalSpeedFallback,

        @NotEmpty @Size(min = 4, max = 4)
        List<@Valid CornerConfig> corners,

        boolean startRecording,
        boolean stopRecording,
        @NotNull @DecimalMin("1.2") Double closingHeight,
        Double closingHoverSeconds
) {

    /**
     * Per-corner override for a {@link MissionPatternType#PERIMETER_INSPECTION}
     * pattern. All fields except {@code fileSuffix} are required — this
     * pattern is intentionally explicit per corner rather than falling
     * back to shared defaults, since the whole point of this pattern is
     * that corners differ.
     */
    public record CornerConfig(
            @NotNull @DecimalMin("1.2") Double height,
            Double speed,
            @NotNull Double gimbalPitchAngle,
            String fileSuffix,
            List<WaypointMissionRequest.WaypointActionType> extraActions
    ) {}
}