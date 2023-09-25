package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;

import com.by.khodasartyom.model.admin.Admin;
import com.by.khodasartyom.model.admin.AdminSignInDto;
import com.by.khodasartyom.model.admin.AdminSignUpDto;
import com.by.khodasartyom.repository.AdminRepository;
import com.by.khodasartyom.model.security.AccessToken;
import com.by.khodasartyom.model.security.AdminPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;


@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final AccessTokenService accessTokenService;
    private final PasswordEncoder passwordEncoder;
    private final TransactionOperations transactionOperations;


    @Override
    public AccessToken signIn(AdminSignInDto dto) {
        Admin admin = adminRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadCredentialsException("THere is no such email"));
        if (!passwordEncoder.matches(dto.getPassword(), admin.getPasswordHash())) {
            throw new BadCredentialsException("Incorrect password");
        }
        AdminPrincipal adminPrincipal = AdminPrincipal.from(admin);
        return accessTokenService.generate(adminPrincipal);
    }

    @Override
    public AccessToken signUp(AdminSignUpDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        Admin admin = this.create(dto, passwordHash);

        AdminPrincipal adminPrincipal = AdminPrincipal.from(admin);
        return accessTokenService.generate(adminPrincipal);
    }

    private Admin create(AdminSignUpDto dto, String passwordHash) {
        return transactionOperations.execute(tx -> {
            boolean existByEmail = adminRepository.findByEmail(dto.getEmail()).isPresent();
            if (existByEmail) {
                throw new BusinessException("Such email is exist");

            }
            Admin admin = new Admin()
                    .setEmail(dto.getEmail())
                    .setPasswordHash(passwordHash)
                    .setName(dto.getName());
            adminRepository.create(admin);

            return admin;
        });
    }


}
