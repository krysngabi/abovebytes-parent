package com.abovebytes.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class UrlUtils {

    private UrlUtils() {
        // utility class
    }

    /**
     * Builds a URL from a base and a relative path, normalizing slashes,
     * and validates that the result is a syntactically valid URL.
     *
     * @param baseUrl the base URL (e.g. fileVaultConfig.getVaultUrl())
     * @param path    the path/segment to append (e.g. user.getProfilePicture())
     * @return the validated, normalized URL as a String
     * @throws IllegalArgumentException if baseUrl or path is null/blank,
     *                                   or the constructed value is not a valid URL
     */
    public static String buildAndValidateUrl(String baseUrl, String path) {
        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalArgumentException("Base URL must not be null or blank");
        }
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Path must not be null or blank");
        }

        String normalizedBase = baseUrl.endsWith("/")
                ? baseUrl.substring(0, baseUrl.length() - 1)
                : baseUrl;
        String normalizedPath = path.startsWith("/")
                ? path
                : "/" + path;

        String result = normalizedBase + normalizedPath;

        validate(result);

        return result;
    }

    /**
     * Validates that the given string is both a syntactically correct URI
     * and a well-formed URL (has a valid scheme, host, etc.).
     */
    public static void validate(String urlString) {
        try {
            URI uri = new URI(urlString);
            // toURL() forces scheme/host validation that URI alone doesn't guarantee
            URL url = uri.toURL();

            if (url.getHost() == null || url.getHost().isBlank()) {
                throw new IllegalArgumentException("Constructed URL has no host: " + urlString);
            }
        } catch (URISyntaxException | MalformedURLException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid URL constructed: " + urlString, e);
        }
    }
}