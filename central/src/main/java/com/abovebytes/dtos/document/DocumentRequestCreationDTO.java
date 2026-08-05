package com.abovebytes.dtos.document;

import com.abovebytes.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DocumentRequestCreationDTO(
        @NotNull(message = "user.id.required")
        Long userId,

        @NotNull(message = "gender.required")
        Gender gender,

        @NotNull(message = "document.id.required")
        Long documentId,

        @NotBlank(message = "address.required")
        String address,

        @NotNull(message = "province.id.required")
        Long provinceId,

        @NotNull(message = "city.id.required")
        Long cityId,

        @NotNull(message = "township.id.required")
        Long townshipId,

        @NotNull(message = "quarter.id.required")
        Long quarterId,

        Long streetId,

        // User details
        @NotBlank(message = "first.name.required")
        String firstName,

        @NotBlank(message = "last.name.required")
        String lastName,

        // User details
        @NotBlank(message = "middle.name.required")
        String middleName,

        @NotBlank(message = "place.of.birth.required")
        String placeOfBirth,

        @NotBlank(message = "dob.required")
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "invalid.dob")
        String dateOfBirth,

        @NotBlank(message = "occupation.required")
        String occupation,

        @NotBlank(message = "citizenship.required")
        String citizenship,

        @NotBlank(message = "sector.required")
        String sector,

        @NotBlank(message = "territory.required")
        String territory,

// Father details
        @NotBlank(message = "dad.first.name.required")
        String dadFirstName,

        @NotBlank(message = "dad.last.name.required")
        String dadLastName,

        @NotBlank(message = "dad.middle.name.required")
        String dadMiddleName,

        @NotBlank(message = "dad.place.of.birth.required")
        String dadPlaceOfBirth,

        @NotBlank(message = "dad.dob.required")
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "dad.invalid.dob")
        String dadDateOfBirth,

        @NotBlank(message = "dad.occupation.required")
        String dadOccupation,

        @NotBlank(message = "dad.citizenship.required")
        String dadCitizenship,

        @NotBlank(message = "dad.sector.required")
        String dadSector,

        @NotBlank(message = "dad.territory.required")
        String dadTerritory,

// Mother details
        @NotBlank(message = "mom.first.name.required")
        String momFirstName,

        @NotBlank(message = "mom.last.name.required")
        String momLastName,

        @NotBlank(message = "mom.middle.name.required")
        String momMiddleName,

        @NotBlank(message = "mom.place.of.birth.required")
        String momPlaceOfBirth,

        @NotBlank(message = "mom.dob.required")
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "mom.invalid.dob")
        String momDateOfBirth,

        @NotBlank(message = "mom.occupation.required")
        String momOccupation,

        @NotBlank(message = "mom.citizenship.required")
        String momCitizenship,

        @NotBlank(message = "mom.sector.required")
        String momSector,

        @NotBlank(message = "mom.territory.required")
        String momTerritory

) {
}
