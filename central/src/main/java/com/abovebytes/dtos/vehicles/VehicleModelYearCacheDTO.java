package com.abovebytes.dtos.vehicles;

import com.abovebytes.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleModelYearCacheDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long vehicleId;

    private Long modelId;

    private Integer year;

    private String make;

    private String model;

    private String makeModel;

    private Long createdBy;

    private Long lastModifiedBy;

    private Status status;

    private LocalDateTime createDate;

    private LocalDateTime lastModified;
}