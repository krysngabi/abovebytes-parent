package com.abovebytes.dtos.featureflag;

import com.abovebytes.enums.Status;
import lombok.Getter;

@Getter
public class FeatureFlagDto {
    private final String name;
    private final Status status;

    public FeatureFlagDto(String name, Status status) {
        this.name = name;
        this.status = status;
    }

}