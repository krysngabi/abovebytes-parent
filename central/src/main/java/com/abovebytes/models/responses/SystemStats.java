package com.abovebytes.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SystemStats {
    private String totalRam;
    private String usedRam;
    private String freeRam;
    private String freeRamPercentage;

    private String totalDisk;
    private String usedDisk;
    private String freeDisk;

    private int cpuCores;
    private String cpuLoad;
    private String cpuLoadStatus;
}
