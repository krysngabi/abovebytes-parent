package com.abovebytes.models.emergency.uav;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * Parameters for a {@link MissionPatternType#TWO_POINT_TRANSECT} mission:
 * fly from point A to point B in a straight line, pausing at the midpoint
 * to rotate the gimbal to a downward (nadir) angle and take a photo, then
 * at point B execute a configurable set of actions, then reverse heading
 * and fly straight back to point A before landing via the mission's own
 * {@code finishAction}.
 * <p>
 * Unlike {@link SimpleHopTestParams} (which defines the forward point by
 * distance and heading from a single center point), this pattern takes
 * two independent GPS coordinates directly — suited to real-world cases
 * where the operator has picked two specific points on a map (e.g. two
 * ends of a fence line, wall, or field edge) rather than a distance to
 * travel.
 * <p>
 * Generates four waypoints: point A (arrival, climbed and oriented
 * toward B), the midpoint (nadir photo), point B (configured actions),
 * and a return to point A (heading reversed, gimbal leveled). All four
 * share the same {@code climbHeight} — this pattern does not vary
 * altitude along the transect.
 *
 * @param pointALatitude     Latitude of the start/return point.
 * @param pointALongitude    Longitude of the start/return point.
 * @param pointBLatitude     Latitude of the far point.
 * @param pointBLongitude    Longitude of the far point.
 * @param climbHeight        Height (meters, relative to takeoff point) held for
 *                            the entire transect — all four waypoints use this
 *                            same altitude.
 * @param speed               Flight speed (m/s) for all legs. Falls back to the
 *                            mission's {@code globalSpeed} if {@code null}.
 * @param midGimbalPitch      Gimbal pitch (degrees) at the midpoint. Defaults to
 *                            {@code -90} (straight down / nadir) if {@code null}.
 * @param midPhotoFileSuffix  Filename suffix for the midpoint photo. Defaults to
 *                            {@code "transect_mid_nadir"} if {@code null}.
 * @param pointBGimbalPitch   Gimbal pitch (degrees) to hold while executing
 *                            {@code actionsAtPointB}. Required — this pattern
 *                            expects an explicit angle at the far point rather
 *                            than inheriting the midpoint's nadir angle.
 * @param actionsAtPointB     Actions to execute at point B, in order (e.g.
 *                            {@code HOVER} then {@code TAKE_PHOTO}). A
 *                            {@code TAKE_PHOTO} entry in this list is tagged
 *                            with {@code pointBPhotoFileSuffix}.
 * @param pointBPhotoFileSuffix Filename suffix used for any {@code TAKE_PHOTO}
 *                            action in {@code actionsAtPointB}. Defaults to
 *                            {@code "transect_point_b"} if {@code null}.
 * @param returnGimbalPitch  Gimbal pitch (degrees) held during the return leg
 *                            back to point A. Defaults to {@code 0} (level)
 *                            if {@code null}.
 */
public record TwoPointTransectParams(
        @NotNull Double pointALatitude,
        @NotNull Double pointALongitude,
        @NotNull Double pointBLatitude,
        @NotNull Double pointBLongitude,
        @NotNull @DecimalMin("1.2") Double climbHeight,
        Double speed,
        Double midGimbalPitch,
        String midPhotoFileSuffix,
        @NotNull Double pointBGimbalPitch,
        List<WaypointMissionRequest.WaypointActionType> actionsAtPointB,
        String pointBPhotoFileSuffix,
        Double returnGimbalPitch
) {}