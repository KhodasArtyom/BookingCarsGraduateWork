package com.by.khodasartyom.service;

import com.by.khodasartyom.model.security.AccessToken;
import com.by.khodasartyom.model.security.AccountPrincipal;

public interface AccessTokenService {

    AccessToken generate(AccountPrincipal accountPrincipal);

    AccountPrincipal authenticate(String accessTokenValue);
}
