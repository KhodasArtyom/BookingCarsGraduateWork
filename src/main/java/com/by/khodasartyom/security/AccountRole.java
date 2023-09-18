package com.by.khodasartyom.security;

import org.springframework.security.core.GrantedAuthority;

public enum AccountRole implements GrantedAuthority {
    ADMIN,
    USER;

    @Override
    public String getAuthority() {
        return "ROLE" + this.name();
    }
}
