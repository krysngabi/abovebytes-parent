package com.abovebytes.models.requests;

import java.util.List;

public record EndpointPermission(
        List<String> endpoints,
        List<String> roles
) {
}