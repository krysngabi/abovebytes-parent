package com.abovebytes.dtos.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLocationDto {
    private Long userId;
    private String phone;
    private String userFullName;
    private String email;
    private String profilePicture;
    private Double rating;
    private boolean verified;
}