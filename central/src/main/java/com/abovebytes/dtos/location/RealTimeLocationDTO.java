package com.abovebytes.dtos.location;

import com.abovebytes.dtos.user.UserLocationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealTimeLocationDTO {
    private Long id;
    private double latitude;
    private double longitude;
    private UserLocationDto user;
    String distanceInMetrics;
    String directionLink;
    String userTypeIcon;
    String userType;
}