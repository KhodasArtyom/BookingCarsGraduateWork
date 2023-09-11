package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.admin.AdminSignInDto;
import com.by.khodasartyom.model.entityandDto.admin.AdminSignUpDto;
import com.by.khodasartyom.model.security.AccessToken;
import com.by.khodasartyom.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;

    @Override
    public AccessToken signIn(AdminSignInDto dto) {

    }

    @Override
    public AccessToken signUp(AdminSignUpDto dto) {
        return null;
    }
}
