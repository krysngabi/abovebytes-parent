package com.abovebytes.models.emergency.uav;

public enum MissionPatternType {
    CUSTOM,            // explicit waypoints, current behavior
    SQUARE_PERIMETER,  // 4 corners, 2 waypoints each (arrival +
    PERIMETER_INSPECTION, // diamond loop, per-corner overrides, record bookend
    ORBIT,             // circular loop around a center point
    GRID_SURVEY        // lawnmower rows over a rectangular area
}