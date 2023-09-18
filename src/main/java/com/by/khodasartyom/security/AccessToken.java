package com.by.khodasartyom.security;


import lombok.*;

import java.time.Instant;

@Value
public class AccessToken {
    String value;
    AccountPrincipal principal;
    Instant issuedAt;
    Instant expiresAt;
}
