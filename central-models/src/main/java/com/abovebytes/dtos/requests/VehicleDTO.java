package com.abovebytes.dtos.requests;


import com.abovebytes.dtos.ResponseDTO;
import com.abovebytes.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehicleDTO extends ResponseDTO {
    private String ownerName;
    private String ownerPhone;
    private String city;
    private String township;
    private String address;
    private String vin;
    private String licensePlate;
    private String status;
    private String statusUnfiltered;
    private String statusColor;
    private String vehicleColor;
    private String vehicleType;
    private VehicleType typeOfVehicle;
    private UUID vehicleId;
    private LocalDateTime lastService;
}
