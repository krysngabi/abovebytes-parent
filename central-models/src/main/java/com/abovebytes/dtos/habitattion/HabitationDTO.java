package com.abovebytes.dtos.habitattion;

import com.abovebytes.enums.HabitationStatus;
import com.abovebytes.models.responses.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HabitationDTO extends BaseResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long habitationId;
    private String systemId;
    private String address;
    private String zipCode;
    private String ownerName;
    private String ownerPhone;
    private String houseStatus;
    private String statusColor;
    private String creationDate;
    private String provinceLabel;
    private String cityLabel;
    private String townshipLabel;
    private String countryLabel;
    private String countryCode;
    private String timeZone;
    BigDecimal longitude;
    BigDecimal latitude;
    private String quarterLabel;
    private String streetLabel;
    private Long countryId;
    private Long currencyId;
    private Long provinceId;
    private Long cityId;
    private Long townshipId;
    private Long quarterId;
    private Long streetId;
    private LocalDateTime createdAt;
    private String tempPassword;
    private HabitationStatus status;
    private Long createdBy;
    private boolean isForTest;
    private boolean isDeletable;

}
