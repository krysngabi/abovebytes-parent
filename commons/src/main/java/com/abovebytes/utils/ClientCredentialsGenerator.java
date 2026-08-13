package com.abovebytes.utils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;

/**
 * Utility class for generating cryptographically secure API credentials such as Client IDs
 * and Client Secrets using {@link SecureRandom} and Base64 URL-safe encoding.
 *
 * <p>By default, Client IDs are prefixed with {@code cli_} (20 characters payload) and
 * Client Secrets are prefixed with {@code sec_} (40 characters payload).</p>
 *
 * <p>This class is thread-safe and non-instantiable.</p>
 */
public final class ClientCredentialsGenerator {

    /** Default prefix for generated Client IDs. */
    public static final String DEFAULT_CLIENT_ID_PREFIX = "cli_";

    /** Default prefix for generated Client Secrets. */
    public static final String DEFAULT_CLIENT_SECRET_PREFIX = "sec_";

    /** Default character length for Client ID random payloads. */
    public static final int DEFAULT_CLIENT_ID_LENGTH = 20;

    /** Default character length for Client Secret random payloads. */
    public static final int DEFAULT_CLIENT_SECRET_LENGTH = 40;

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final Base64.Encoder BASE64_URL_ENCODER = Base64.getUrlEncoder().withoutPadding();

    // Prevent instantiation
    private ClientCredentialsGenerator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Generates a default Client ID with prefix {@code cli_} and 20 random Base64 characters.
     *
     * @return a formatted Client ID string (e.g., {@code "cli_aB3x9K2pL0mN8vC4qW1z"})
     */
    public static String generateClientId() {
        return generateClientId(DEFAULT_CLIENT_ID_PREFIX, DEFAULT_CLIENT_ID_LENGTH);
    }

    /**
     * Generates a Client ID with a custom prefix and custom character length.
     *
     * @param prefix the prefix prepended to the ID (can be empty, cannot be null)
     * @param length the number of random Base64URL characters to generate
     * @return a formatted Client ID string
     * @throws IllegalArgumentException if length is less than 1 or prefix is null
     */
    public static String generateClientId(String prefix, int length) {
        return generateToken(prefix, length);
    }

    /**
     * Generates a default Client Secret with prefix {@code sec_} and 40 random Base64 characters.
     *
     * @return a formatted Client Secret string (e.g., {@code "sec_..."})
     */
    public static String generateClientSecret() {
        return generateClientSecret(DEFAULT_CLIENT_SECRET_PREFIX, DEFAULT_CLIENT_SECRET_LENGTH);
    }

    /**
     * Generates a Client Secret with a custom prefix and custom character length.
     *
     * @param prefix the prefix prepended to the secret (can be empty, cannot be null)
     * @param length the number of random Base64URL characters to generate
     * @return a formatted Client Secret string
     * @throws IllegalArgumentException if length is less than 1 or prefix is null
     */
    public static String generateClientSecret(String prefix, int length) {
        return generateToken(prefix, length);
    }

    /**
     * Generates a raw URL-safe random token string without any prefix.
     *
     * @param length the number of random characters to generate
     * @return a URL-safe Base64 random string
     * @throws IllegalArgumentException if length is less than 1
     */
    public static String generateRandomToken(int length) {
        return generateToken("", length);
    }

    private static String generateToken(String prefix, int length) {
        Objects.requireNonNull(prefix, "Prefix cannot be null");
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1 character");
        }

        // Each Base64 character represents 6 bits (3 bytes -> 4 Base64 chars).
        // Calculate exact required byte count to satisfy the requested length.
        int byteCount = (int) Math.ceil((length * 3.0) / 4.0);
        byte[] randomBytes = new byte[byteCount];
        SECURE_RANDOM.nextBytes(randomBytes);

        String base64Encoded = BASE64_URL_ENCODER.encodeToString(randomBytes);

        return prefix + base64Encoded.substring(0, length);
    }
}