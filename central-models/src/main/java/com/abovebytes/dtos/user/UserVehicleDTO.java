package com.abovebytes.dtos.user;

import com.abovebytes.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVehicleDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private UUID carId;
    private String makeModelYear;
    private String vin;
    private String logo;
    private String licensePlate;
    private String vehicleColor;
    private String severity;
    private String vehicleType;
    private String status;
    private String statusUnfiltered;
    private String hexColor;
    private String ownerAddress;
    private String agentName;
    private String ownerProvinceVilleCommune;
    private String ownerPhone;
    private String ownerName;
    private VehicleType typeOfVehicle;
    private Long ownerId;
}
