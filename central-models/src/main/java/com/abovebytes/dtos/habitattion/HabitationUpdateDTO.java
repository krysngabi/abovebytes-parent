package com.abovebytes.dtos.habitattion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * Payload for updating an existing habitation's address, geographic
 * hierarchy, and descriptive fields. Does not include owner/user fields
 * (those belong to the user-management flow, not habitation update) nor
 * systemId (immutable once generated — see {@link com.abovebytes.superplaques.entities.Habitation#generateSystemId()})
 * nor status (should be transitioned via a dedicated status-change
 * endpoint, not a general-purpose update, if status changes carry side
 * effects like notifications or audit trails).
 */
public record HabitationUpdateDTO(
        String address,

        String zipCode,

        String details,

        @NotNull(message = "province.id.required")
        @Positive(message = "province.id.must.be.positive")
        Long provinceId,

        @NotNull(message = "city.id.required")
        @Positive(message = "city.id.must.be.positive")
        Long cityId,

        @NotNull(message = "township.id.required")
        @Positive(message = "township.id.must.be.positive")
        Long townshipId,

        @NotNull(message = "quarter.id.required")
        @Positive(message = "quarter.id.must.be.positive")
        Long quarterId,

        Long streetId,

        BigDecimal latitude,

        BigDecimal longitude
) {}