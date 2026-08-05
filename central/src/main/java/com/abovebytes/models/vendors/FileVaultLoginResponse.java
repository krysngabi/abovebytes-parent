package com.abovebytes.models.vendors;

import java.util.List;

public class FileVaultLoginResponse {
    private String message;
    private User user;
    private String token;

    // Getters and Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class User {
        private String uuid;
        private String username;
        private List<Role> roles;
        private String apiKey;
        private String passwordEditedAt;

        // Getters and Setters

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<Role> getRoles() {
            return roles;
        }

        public void setRoles(List<Role> roles) {
            this.roles = roles;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getPasswordEditedAt() {
            return passwordEditedAt;
        }

        public void setPasswordEditedAt(String passwordEditedAt) {
            this.passwordEditedAt = passwordEditedAt;
        }
    }

    public static class Role {
        private String name;

        // Getter and Setter

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
