package com.abovebytes.enums;

import com.abovebytes.exceptions.CommonException;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.HttpStatus;

public enum SortBy {
    ID,
    RATING;

    @JsonCreator
    public static SortBy fromString(String sortBy) {
        try {
            return SortBy.valueOf(sortBy.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new CommonException(HttpStatus.NOT_FOUND, "Invalid sortBy: " + sortBy, "INVALID_SORT_BY");
        }
    }
}
