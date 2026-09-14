package com.abovebytes.models.emergency.uav;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

/**
 * Parameters for a {@link MissionPatternType#SIMPLE_HOP_TEST} mission —
 * the smallest useful end-to-end flight test: takeoff, climb to
 * {@code climbHeight}, move {@code forwardDistanceMeters} in a straight
 * line, rotate the gimbal at the far point (optionally taking a photo),
 * fly straight back to the takeoff coordinates, then land via the
 * mission's own {@code finishAction}.
 * <p>
 * Generates exactly three waypoints: takeoff-point arrival, forward
 * point (with the gimbal/photo action), and return-to-takeoff-point —
 * all at the same altitude, so the only things that change between
 * waypoints are horizontal position and gimbal angle. This keeps the
 * test isolated to validating basic waypoint transit, heading, and
 * gimbal control without altitude changes or multi-leg geometry adding
 * extra variables to a first flight.
 *
 * @param centerLatitude         Latitude of the takeoff/return point.
 * @param centerLongitude        Longitude of the takeoff/return point.
 * @param climbHeight            Height (meters, relative to takeoff point) held
 *                                for the entire hop — both the forward point and
 *                                the return point use this same altitude.
 * @param forwardDistanceMeters  Distance to travel from the takeoff point, in meters.
 * @param headingDegrees         Compass heading (0=N, 90=E, 180=S, 270=W) defining
 *                                the direction of the forward hop. Defaults to due
 *                                north (0) if {@code null}.
 * @param speed                  Flight speed (m/s) for both legs. Falls back to the
 *                                mission's {@code globalSpeed} if {@code null}.
 * @param gimbalTurnPitch        Gimbal pitch angle (degrees) to rotate to at the
 *                                forward point, via a {@code GIMBAL_ROTATE} action.
 * @param gimbalTurnYaw          Gimbal yaw angle (degrees) to rotate to at the
 *                                forward point, in the same action.
 * @param takePhotoAtForwardPoint If true, attaches a {@code TAKE_PHOTO} action
 *                                after the gimbal rotation at the forward point.
 */
public record SimpleHopTestParams(
        @NotNull Double centerLatitude,
        @NotNull Double centerLongitude,
        @NotNull @DecimalMin("1.2") Double climbHeight,
        @NotNull @DecimalMin("0.1") Double forwardDistanceMeters,
        Double headingDegrees,
        Double speed,
        @NotNull Double gimbalTurnPitch,
        Double gimbalTurnYaw,
        boolean takePhotoAtForwardPoint
) {}