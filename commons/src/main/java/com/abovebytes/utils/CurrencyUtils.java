package com.abovebytes.utils;

import com.abovebytes.exceptions.CommonException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public final class CurrencyUtils {

    private CurrencyUtils() {
    }

    /**
     * Validate an ISO-4217 currency code (USD, EUR, CDF, etc.)
     */
    public static boolean isValidCurrencyCode(String code) {
        if (code == null || code.isBlank()) {
            return false;
        }
        try {
            Currency.getInstance(code.toUpperCase(Locale.ROOT));
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Normalize a currency code (returns uppercase or throws)
     */
    public static String normalize(String code, MessageUtils messageUtils) {
        if (!isValidCurrencyCode(code)) {
          throw new CommonException(HttpStatus.BAD_REQUEST, messageUtils.message("invalid.currency.code", code), "400");
        }
        return code.toUpperCase(LocaleContextHolder.getLocale());
    }

    /**
     * Return all supported ISO-4217 currency codes
     */
    public static Set<String> supportedCurrencies() {
        return Currency.getAvailableCurrencies()
                .stream()
                .map(Currency::getCurrencyCode)
                .collect(Collectors.toUnmodifiableSet());
    }
}
