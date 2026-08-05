package com.abovebytes.dtos.search;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public record PlaceSearchRequest(
        @NotNull(message = "user.id.required")
        Long userId,

        @NotNull(message = "search.term.required")
        String searchTerm,

//        @NotNull(message = "radius.required")
        @Min(value = 1, message = "radius.must.be.or.equal.to.one.meter.or.kilometer")
        Long radius,

        List<String> businessCategories,

        int limit,
//        @NotNull(message = "metrics.required")
        boolean useKm
) {
    public long effectiveRadius() {
        return radius != null && radius > 0 ? radius : 10L; // default to 10 km
    }

    public List<String> effectiveCategories() {
        return businessCategories != null ? businessCategories : Collections.emptyList();
    }

    @Override
    public String toString() {
        return "PlaceSearchRequest {" +
                " radius='" + effectiveRadius() + '\'' +
                ", userId='" + userId + '\'' +
                ", limit='" + limit + '\'' +
                ", businessCategories='" + (effectiveCategories().isEmpty() ? "No businessCategories" : Arrays.toString(effectiveCategories().toArray())) + '\'' +
                '}';
    }
}