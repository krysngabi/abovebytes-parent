package com.abovebytes.dtos.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DashboardCountDTO {
    @Builder.Default
    private Long habitationCount = 0L;
    @Builder.Default
    private Long vehicleCount = 0L;
    @Builder.Default
    private long interventionCount = 0L;
    @Builder.Default
    private Long trafficTicketGivenCount = 0L;
    @Builder.Default
    private Long motorcycleCount = 0L;

    @Builder.Default
    private Long userCount = 0L;

    @Builder.Default
    private Integer trafficTicketReceivedCount = 0;
    @Builder.Default
    private Integer trafficTicketPaidCount = 0;
    @Builder.Default
    private Integer trafficTicketUnPaidCount = 0;
    @Builder.Default
    private Integer trafficTicketRemainingBalance = 0;



}
