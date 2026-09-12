package com.abovebytes.models.emergency.uav;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * Parameters used to procedurally generate a set of waypoints for a
 * predefined flight pattern, as an alternative to supplying an explicit
 * {@link WaypointMissionRequest#waypoints()} list.
 * <p>
 * A single {@code PatternParams} instance is interpreted differently
 * depending on the mission's {@link MissionPatternType}: some fields are
 * only relevant to certain patterns and are otherwise ignored. See the
 * per-field docs below for which pattern(s) each field applies to.
 * <p>
 * Expansion into concrete waypoints is performed by
 * {@code WaypointPatternExpander}, which reads these parameters and
 * produces a {@link WaypointMissionRequest.WaypointRequest} list in the
 * same shape the mission builders already expect — so
 * {@code buildTemplateKml}/{@code buildWaylinesWpml} require no changes
 * regardless of which pattern generated the waypoints.
 *
 * @param centerLatitude      Latitude of the pattern's center point, in decimal degrees.
 *                            Used by all pattern types as the anchor the shape is built around.
 * @param centerLongitude     Longitude of the pattern's center point, in decimal degrees.
 *                            Used by all pattern types as the anchor the shape is built around.
 * @param sideLengthMeters    Length of one side of the square, in meters.
 *                            Required for {@link MissionPatternType#SQUARE_PERIMETER}
 *                            and {@link MissionPatternType#GRID_SURVEY}; ignored otherwise.
 * @param radiusMeters        Radius of the orbit circle, in meters, measured from
 *                            {@code centerLatitude}/{@code centerLongitude}.
 *                            Required for {@link MissionPatternType#ORBIT}; ignored otherwise.
 * @param orbitPoints         Number of stops evenly distributed around the orbit circle.
 *                            Required for {@link MissionPatternType#ORBIT}; ignored otherwise.
 * @param arrivalHeight       Height (meters, relative to takeoff point) for the first
 *                            waypoint generated at each stop — used to let the aircraft
 *                            settle/stabilize before any action-height climb or gimbal move.
 *                            Applies to all pattern types.
 * @param actionHeight        Height (meters, relative to takeoff point) for the second
 *                            waypoint generated at each stop, where the configured actions
 *                            in {@code actionsAtEachStop} are actually attached.
 *                            Applies to all pattern types.
 * @param arrivalSpeed        Flight speed (m/s) used for the arrival waypoint at each stop.
 * @param actionSpeed         Flight speed (m/s) used for the action waypoint at each stop.
 * @param gimbalArrivalPitch  Gimbal pitch angle (degrees, 0 = horizontal, negative = downward)
 *                            applied at the arrival waypoint. May be {@code null} to leave
 *                            the gimbal pitch unset for that waypoint.
 * @param gimbalActionPitch   Gimbal pitch angle (degrees) applied at the action waypoint,
 *                            typically steeper than {@code gimbalArrivalPitch} for close-up
 *                            or nadir shots. May be {@code null}.
 * @param actionsAtEachStop   The list of {@link WaypointMissionRequest.WaypointActionType}
 *                            values to attach to the action waypoint at every stop generated
 *                            by the pattern (e.g. every corner of a square, every point on an
 *                            orbit). The same action set is applied uniformly at each stop;
 *                            per-stop action customization is not currently supported —
 *                            use {@link MissionPatternType#CUSTOM} with explicit waypoints
 *                            if different stops need different actions.
 */
public record PatternParams(
        @NotNull Double centerLatitude,
        @NotNull Double centerLongitude,

        // SQUARE_PERIMETER / GRID_SURVEY
        Double sideLengthMeters,

        // ORBIT
        Double radiusMeters,
        Integer orbitPoints,

        // shared
        @NotNull @DecimalMin("1.2") Double arrivalHeight,
        @NotNull @DecimalMin("1.2") Double actionHeight,
        @NotNull @DecimalMin("0.1") Double arrivalSpeed,
        @NotNull @DecimalMin("0.1") Double actionSpeed,
        Double gimbalArrivalPitch,
        Double gimbalActionPitch,
        List<WaypointMissionRequest.WaypointActionType> actionsAtEachStop
) {}