package com.abovebytes.notifications.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RoleDto(Long id, String name, String status) {
}
