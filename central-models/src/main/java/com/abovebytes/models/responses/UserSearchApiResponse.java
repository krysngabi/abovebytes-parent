package com.abovebytes.models.responses;

import com.abovebytes.dtos.habitattion.HabitationDTO;
import com.abovebytes.dtos.user.RoleUserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSearchApiResponse {
    private Long userId;
    private String displayName;
    private String status;
    private HabitationDTO userHabitation;
    private String phone;
    private String firstName;
    private String lastName;
    private String friendlyName;
    private String email;
    private String profilePicture;
    private Boolean verified;
    private Double rating;
    private Set<RoleUserDTO> roles;
    private LocalDateTime lastModified;
}
