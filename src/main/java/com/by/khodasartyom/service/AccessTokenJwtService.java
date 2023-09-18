package com.by.khodasartyom.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.by.khodasartyom.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessTokenJwtService implements AccessTokenService{

    private final Algorithm jwtAlgorithm;
    private final JWTVerifier jwtVerifier;
    private final AccessTokenProperties properties;

    @Override
    public AccessToken generate(AccountPrincipal principal) {

        Instant issueAt = Instant.now();
        Instant expiresAt = issueAt.plus(properties.getTimeToLive());
        String tokenValue = JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withSubject(String.valueOf(principal.getId()))
                .withClaim("role",principal.getRole().name())
                .withIssuedAt(issueAt)
                .withExpiresAt(expiresAt)
                .sign(jwtAlgorithm);
        return new AccessToken(tokenValue,principal,issueAt,expiresAt);
    }

    @Override
    public AccountPrincipal authenticate(String accessTokenValue) {
       try{
           DecodedJWT jwt =  jwtVerifier.verify(accessTokenValue);
           long accountId = jwt.getClaim("sub").as(Long.class);
           AccountRole accountRole = jwt.getClaim("role").as(AccountRole.class);
           return switch (accountRole) {
               case ADMIN -> new AdminPrincipal(accountId);
               case USER -> new UserPrincipal(accountId);
           };
       }catch (TokenExpiredException e) {
           throw new CredentialsExpiredException("JWT is expired",e);
       }catch (JWTVerificationException e) {
           throw new BadCredentialsException("JWT is invalid",e);
       }
    }
}
