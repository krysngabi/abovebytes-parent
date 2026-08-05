package com.abovebytes.models.requests;

import java.util.List;

public record RolePermission(
        String role,
        List<String> endpoints
) {
}