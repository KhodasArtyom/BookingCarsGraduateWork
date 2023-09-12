package com.by.khodasartyom.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.by.khodasartyom.model.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialExpiredException;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessTokenJwtService implements AccessTokenService {

    private final Algorithm jwtAlgorithm;
    private final JWTVerifier jwtVerifier;
    private final AccessTokenProperties accessTokenProperties;

    @Override
    public AccessToken generate(AccountPrincipal accountPrincipal) {
        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(accessTokenProperties.getTimeToLive());
        String tokenValue = JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withSubject(String.valueOf(accountPrincipal.getId()))
                .withClaim("role", accountPrincipal.getRole().name())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(jwtAlgorithm);

        return new AccessToken(tokenValue, accountPrincipal, issuedAt, expiresAt);
    }

    @Override
    public AccountPrincipal authenticate(String accessTokenValue) {
        try {
            DecodedJWT jwt = jwtVerifier.verify(accessTokenValue);
            long accountId = jwt.getClaim("sub").as(Long.class);
            Role role = jwt.getClaim("role").as(Role.class);

            return switch (role) {
                case ADMIN -> new AdminPrincipal(accountId);
                case USER -> new UserPrincipal(accountId);
            };
        } catch (TokenExpiredException e) {
            throw new CredentialsExpiredException("JWT is expired", e);
        }catch (JWTVerificationException e) {
            throw new BadCredentialsException("JWT is invalid",e);
        }
    }
}
