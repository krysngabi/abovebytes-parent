package com.abovebytes.paymentswitch.models.enums;

import com.abovebytes.exceptions.CommonException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

@Getter
public enum RoleValue {

    MERCHANT("Merchant", "Marchand"),
    CUSTOMER("Customer", "Client");

    private final String englishDescription;
    private final String frenchDescription;

    RoleValue(String englishDescription, String frenchDescription) {
        this.englishDescription = englishDescription;
        this.frenchDescription = frenchDescription;
    }

    @JsonCreator
    public static RoleValue fromString(String role) {
        try {
            return RoleValue.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new CommonException(HttpStatus.NOT_FOUND, "Invalid role: " + role, "INVALID_ROLE");
        }
    }

    public String getDescription() {
        String lang = LocaleContextHolder.getLocale().getLanguage();
        return "fr".equals(lang) ? frenchDescription : englishDescription;
    }
}