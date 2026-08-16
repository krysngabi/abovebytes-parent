package com.abovebytes.utils;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class CountryValidator {

    public static boolean isValidIsoCountryCode(String code) {
        if (code == null || code.length() != 2) return false;
        for (Locale locale : Locale.getAvailableLocales()) {
            if (code.equalsIgnoreCase(locale.getCountry())) {
                return true;
            }
        }
        return false;
    }

    public static String getCountryName(String code) {
        if (code == null || code.length() != 2) return null;
        return Locale.of("", code.toUpperCase()).getDisplayCountry(LocaleContextHolder.getLocale());
    }
}