package com.abovebytes.dtos.habitattion;

import com.abovebytes.dtos.requests.NameCreationDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TownshipServiceCreationRequest(
        @NotNull(message = "township.id.required")
        Long townshipId,

        @NotEmpty(message = "at.least.one.service.required")
        List<@Valid NameCreationDTO> services
) {
}
