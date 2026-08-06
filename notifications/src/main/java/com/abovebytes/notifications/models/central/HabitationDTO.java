package com.abovebytes.notifications.models.central;


import com.abovebytes.notifications.models.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HabitationDTO extends BaseResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long habitationId;
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
    BigDecimal longitude;
    BigDecimal latitude;
    private String quarterLabel;
    private Long countryId;
    private Long provinceId;
    private Long cityId;
    private Long townshipId;
    private Long quarterId;
    private Long streetId;

    @Override
    public String toString() {
        return "HabitationDTO{" +
                "habitationId=" + habitationId +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", houseStatus='" + houseStatus + '\'' +
                ", statusColor='" + statusColor + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", provinceLabel='" + provinceLabel + '\'' +
                ", cityLabel='" + cityLabel + '\'' +
                ", townshipLabel='" + townshipLabel + '\'' +
                ", countryLabel='" + countryLabel + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", quarterLabel='" + quarterLabel + '\'' +
                ", countryId=" + countryId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", townshipId=" + townshipId +
                ", quarterId=" + quarterId +
                ", streetId=" + streetId +
                '}';
    }
}
