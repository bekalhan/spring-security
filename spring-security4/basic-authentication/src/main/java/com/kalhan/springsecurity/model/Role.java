package com.kalhan.springsecurity.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_MOD("BERAT"),
    ROLE_KALHAN("KALHAN");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}