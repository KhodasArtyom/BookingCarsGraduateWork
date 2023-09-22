package com.by.khodasartyom.service;


import com.by.khodasartyom.model.security.AccessToken;
import com.by.khodasartyom.model.user.UserSignInDto;
import com.by.khodasartyom.model.user.UserSignUpDto;

public interface UserService {
    AccessToken signIn(UserSignInDto dto);

    AccessToken signUp(UserSignUpDto dto);
}
