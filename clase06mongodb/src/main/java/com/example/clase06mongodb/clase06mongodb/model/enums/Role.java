package com.example.clase06mongodb.clase06mongodb.model.enums;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("Usuario"),
    ADMIN("Administrador");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}