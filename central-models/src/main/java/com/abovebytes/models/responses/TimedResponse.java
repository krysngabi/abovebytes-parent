package com.abovebytes.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimedResponse<T> {
    private T response;
    private long durationMs;
}