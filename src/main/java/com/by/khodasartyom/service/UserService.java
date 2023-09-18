package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.users.UserDto;
import com.by.khodasartyom.model.entityandDto.users.UserSignInDto;
import com.by.khodasartyom.model.entityandDto.users.UserSignUpDto;
import com.by.khodasartyom.security.AccessToken;

public interface UserService {
    AccessToken signIn(UserSignInDto dto);

    AccessToken signUp(UserSignUpDto dto);
}
