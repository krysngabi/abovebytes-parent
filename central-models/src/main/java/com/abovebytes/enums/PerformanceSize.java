package com.abovebytes.enums;

import com.abovebytes.exceptions.CommonException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum PerformanceSize {
    // Format: DESCRIPTION, DEFAULT_KEYS
    SMALL(10000L, 1000L),
    MEDIUM(500000L, 5000L),
    LARGE(1000000L, 10000L),
    HUGE(10000000L, 100000L),;

    private final Long loadCount;
    private final Long batchSize;

    PerformanceSize(Long loadCount, Long batchSize) {
        this.loadCount = loadCount;
        this.batchSize = batchSize;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PerformanceSize fromString(String keyString) {
        for (PerformanceSize performanceSize : PerformanceSize.values()) {
            if (performanceSize.name().equalsIgnoreCase(keyString)) {
                return performanceSize;
            }
        }
        throw new CommonException(HttpStatus.BAD_REQUEST, "Invalid Performance size Family: " + keyString, "400");
    }
}