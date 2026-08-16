package com.abovebytes.constants;

import com.abovebytes.enums.RoleValue;

import java.util.List;
import java.util.Set;

public class CentralConstants {
    public static final String localPath = "/api/central/users/refresh_token";
    public static final String devPath = "/central/users/refresh_token";
    public static final String BEARER_ = "Bearer ";
    public static List<String> allowedUserSortProperties = List.of("userId", "friendlyName", "email", "createDate", "firstName", "lastname", "displayName");
    public static List<String> allowedHabitationSortProperties = List.of("habitationId", "address", "township", "createDate");

    public static final String ABOVE_BYTES_CONTACT_PHONE = "+19254211565";
    public static final Integer PASSWORD_EXPIRY_DAYS_INT = 30;
    public static final Integer PASSWORD_EXPIRY_DAYS_MAX_INT = 90;
    public static final String REST_CONNECTION_TIMEOUT = "restTemplate.connectionTimeoutInSeconds";
    public static final String REST_READ_TIMEOUT = "restTemplate.readTimeoutInSeconds";
    public static final String PROHIBITED_PASSWORD_LIST_FILE = "prohibited_password_list.txt";
    public static final String CENTRAL_PROPERTIES_FILE = "central.properties";
    public static final String FRENCH_DATE_TIME_FORMATTER = "dd/MM/yyyy HH:mm:ss";
    public static final String ENGLISH_DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    public static final String STRIPE_URL_PREFIX = "/stripe";
    public static final String X_API_KEY = "x-api-key";
    public  static final String BY_PASS_TEST_MODE = "X-Bypass-Test-Mode";
    public static final List<RoleValue> testUserRoles = List.of(RoleValue.HOUSE_USER, RoleValue.ROAD_POLICE, RoleValue.VEHICLE_REGISTERER);
    public static final List<RoleValue> selfSignUpRoles = List.of(RoleValue.HOUSE_USER);
    public static final Set<String> stableKeysIos = Set.of(
            "isPhysicalDevice",
            "modelName",
            "localizedModel",
            "systemName",
            "systemVersion",
            "identifierForVendor",
            "physicalRamSize",
            "model",
            "name"
    );

    public static final Set<String> stableKeysAndroid = Set.of(
            "isPhysicalDevice",
            "manufacturer",
            "brand",
            "model",
            "name",
            "device",
            "product",
            "hardware",
            "id",
            "type",
            "physicalRamSize",
            "totalDiskSize"
    );
}