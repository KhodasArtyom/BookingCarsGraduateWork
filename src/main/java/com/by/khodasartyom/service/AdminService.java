package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.admin.AdminSignInDto;
import com.by.khodasartyom.model.entityandDto.admin.AdminSignUpDto;
import com.by.khodasartyom.security.AccessToken;

public interface AdminService {
    AccessToken signIn(AdminSignInDto dto);


    AccessToken signUp(AdminSignUpDto dto);
}
