package com.by.khodasartyom.service;

import com.by.khodasartyom.security.AccessToken;
import com.by.khodasartyom.security.AccountPrincipal;
import org.springframework.stereotype.Component;


public interface AccessTokenService {

    AccessToken generate(AccountPrincipal principal);

    AccountPrincipal authenticate(String accessToken);


}
