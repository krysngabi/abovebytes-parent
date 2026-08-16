package com.abovebytes.utils;

import com.abovebytes.exceptions.CommonException;
import org.springframework.http.HttpStatus;
import java.util.regex.Pattern;

public class EmailUtils {

    // Pre-compiled regex for better performance
    private static final String EMAIL_REGEX = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates an email string against @NotBlank and custom @Pattern logic.
     * * @param email The email string to validate
     * @throws CommonException if validation fails
     */
    public static void validateEmail(String email, MessageUtils messageUtils) {
        // 1. @NotBlank check
        if (email == null || email.trim().isEmpty()) {
            throw new CommonException(HttpStatus.BAD_REQUEST, "Email required", "400");
        }

        // 2. @Pattern and @Email check
        if (!PATTERN.matcher(email).matches()) {
            throw new CommonException(HttpStatus.BAD_REQUEST, messageUtils.message("invalid.email"), "400");
        }
    }

    /**
     * Simple boolean check version
     */
    public static boolean isValid(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return PATTERN.matcher(email).matches();
    }
}