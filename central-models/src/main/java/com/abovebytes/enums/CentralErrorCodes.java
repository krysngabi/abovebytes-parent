package com.abovebytes.enums;

import lombok.Getter;

@Getter
public enum CentralErrorCodes {
    ERR_02("Erreur lors de la connexion"),
    ERR_03("Erreur lors de la modification du mot de passe"),
    ERR_04("Erreur avec le push token"),
    ERR_05("Erreur lors d'une recherche"),
    ERR_06("Erreur avec une opération base de données"),
    PAYMENT_ALREADY_EXISTS("Le paiement existe déjà"),
    REDIRECT_TO_LOGIN("Redirection non autorisée vers la page de connexion"),
    HOUSE_REG_DUPLICATE_OWNER_PHONE(""),
    HABITATION_REQUIRED(""),
    HABITATION_DISABLED(""),
    PASSWORD_REUSED(""),
    INVALID_PASSWORD(""),
    INVALID_TEMP_PASSWORD(""),
    UPDATE_PASSWORD_FAILED(""),
    PASSWORD_VALIDATION_FAILED("")
    ;

    private final String message;

    CentralErrorCodes(String message) {
        this.message = message;
    }
}