package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.users.UserSignInDto;
import com.by.khodasartyom.model.entityandDto.users.UsersSignUpDto;
import com.by.khodasartyom.model.security.AccessToken;

public interface UserService {

    AccessToken signIn(UserSignInDto dto);

    AccessToken signUp(UsersSignUpDto dto);
}
