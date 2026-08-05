package com.abovebytes.enums;

import com.abovebytes.exceptions.CommonException;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.HttpStatus;

public enum SortDirection {
    ASC,
    DESC;

    @JsonCreator
    public static SortDirection fromString(String sortDirection) {
        try {
            return SortDirection.valueOf(sortDirection.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new CommonException(HttpStatus.NOT_FOUND, "Invalid sortDirection: " + sortDirection, "INVALID_SORT_DIRECTION");
        }
    }
}
