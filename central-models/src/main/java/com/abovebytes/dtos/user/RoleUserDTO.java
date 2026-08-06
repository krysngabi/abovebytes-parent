package com.abovebytes.dtos.user;

import com.abovebytes.enums.RoleValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class RoleUserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long roleUserId;
    private Long roleId;
    // to be deleted later and just use id, keeping it to avoid breaking the front end
    private Long id;

    private String description;

    @JsonProperty("name")
    private RoleValue role;

    private boolean requiresVerification;
    private boolean requiresPrinter;
    private String redirectToMobileAppRoute;
    private String status;

    @JsonProperty("description")
    public String getDescription() {
        return role != null ? role.getDescription() : null;
    }
}