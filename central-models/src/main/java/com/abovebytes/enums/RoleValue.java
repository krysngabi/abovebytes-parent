package com.abovebytes.enums;//import com.abovebytes.superplaques.constants.HumanitarianIcons;


import com.abovebytes.constants.HumanitarianIcons;
import com.abovebytes.constants.Icons;
import com.abovebytes.exceptions.CommonException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public enum RoleValue {
    APPLICATION(Icons.bugReport, "Icons", "Application", "Application", false, false, null),
    TEST_DATA_CREATOR(Icons.bugReport, "Icons", "Test Data Creator", "Créateur de données test", false, false, AppEnums.AddTestUserRoute.name()),
    MEDICAL_CORP(HumanitarianIcons.ambulance, "HumanitarianIcons", "Medical Corp", "Corps médical", true, true, null),
    HOUSE_USER(Icons.person_pin_circle, "Icons", "House User", "Utilisateur", false, false, null),
    POLICE(Icons.local_police, "Icons", "Police", "Police", true, true, null),
    SUPER_ADMIN(Icons.admin_panel_settings, "Icons", "Super Admin", "Super administrateur", true, true, null),
    HOUSE_OWNER(Icons.house, "Icons", "House Owner", "Propriétaire de maison", false, false, null),
    HOUSE_REGISTERER(Icons.house, "Icons", "House Registerer", "Enregistreur de maison", true, true, null),
    SUPERVISOR(Icons.supervisor_account, "Icons", "Supervisor", "Superviseur", true, true, null),
    VIEWER(Icons.visibility, "Icons", "Viewer", "Spectateur", false, true, null),
    VEHICLE_REGISTERER(Icons.car_rental, "Icons", "Vehicle Registerer", "Enregistreur de véhicule", true, true, null),
    ROAD_POLICE(Icons.badge, "Icons", "Road Enforcement", "Police de circulation", true, true, null),
    CAR_OWNER(Icons.directions_car, "Icons", "Car Owner", "Propriétaire de voiture", false, false, null),
    DOCUMENT_VALIDATOR(Icons.person_pin_circle, "Icons", "Document validator", "Validateur des documents", false, false, null),
    DOCTOR(Icons.local_hospital, "Icons", "Doctor", "Médecin", false, true, null),
    MESSAGE_OPERATOR(Icons.message, "Icons", "Message operator", "Opérateur message", true, false, null);

    private final String icon;
    private final String iconPrefix;
    private final String englishDescription;
    private final String frenchDescription;
    private final boolean requiresVerification;
    private final boolean requiresPrinter;
    private final String redirectToMobileAppRoute;

    RoleValue(String icon, String iconPrefix, String englishDescription,
              String frenchDescription, boolean requiresVerification, boolean requiresPrinter, String redirectToMobileAppRoute) {
        this.icon = icon;
        this.iconPrefix = iconPrefix;
        this.englishDescription = englishDescription;
        this.frenchDescription = frenchDescription;
        this.requiresVerification = requiresVerification;
        this.requiresPrinter = requiresPrinter;
        this.redirectToMobileAppRoute = redirectToMobileAppRoute;
    }

    @JsonCreator
    public static RoleValue fromString(String role) {
        try {
            return RoleValue.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new CommonException(HttpStatus.NOT_FOUND, "Invalid role: " + role, "INVALID_ROLE");
        }
    }

    public String getUserTypeIcon() {
        return iconPrefix + "." + resolveIconFieldName();
    }

    private String resolveIconFieldName() {
        try {
            Class<?> iconClass = Class.forName("com.abovebytes.superplaques.constants." + iconPrefix);
            for (var field : iconClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(null).equals(icon)) {
                    return field.getName();
                }
            }
        } catch (Exception ignored) {
        }
        return "UNKNOWN";
    }

    public String getDescription() {
        String lang = LocaleContextHolder.getLocale().getLanguage();
        return "fr".equals(lang) ? frenchDescription : englishDescription;
    }

    /**
     * Get the list of roles allowed to bypass test mode
     * @return list of RoleValue that are allowed to bypass test mode
     */
    public static List<RoleValue> getAllowedToBYPassTestMode() {
        return List.of(SUPER_ADMIN);
    }
}