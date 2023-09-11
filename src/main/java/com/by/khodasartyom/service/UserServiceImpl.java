package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.entityandDto.admin.Admin;
import com.by.khodasartyom.model.entityandDto.admin.AdminSignUpDto;
import com.by.khodasartyom.model.entityandDto.users.UserSignInDto;
import com.by.khodasartyom.model.entityandDto.users.Users;
import com.by.khodasartyom.model.entityandDto.users.UsersSignUpDto;
import com.by.khodasartyom.model.security.AccessToken;

import com.by.khodasartyom.model.security.AdminPrincipal;
import com.by.khodasartyom.model.security.UserPrincipal;
import com.by.khodasartyom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final AccessTokenService accessTokenService;
    private final PasswordEncoder passwordEncoder;
    private final TransactionOperations transactionOperations;

    @Override
    public AccessToken signIn(UserSignInDto dto) {
        Users user = usersRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadCredentialsException("There is no such email address. Try again"));
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        UserPrincipal userPrincipal = UserPrincipal.from(user);

        return accessTokenService.generate(userPrincipal);
    }

    @Override
    public AccessToken signUp(UsersSignUpDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        Users users = create(dto, passwordHash);
        UserPrincipal userPrincipal = UserPrincipal.from(users);

        return accessTokenService.generate(userPrincipal);
    }

    private Users create(UsersSignUpDto dto, String passwordHash) {

        return transactionOperations.execute(tx -> {
            boolean existByEmail = usersRepository.findByEmail(dto.getEmail()).isPresent();
            if (existByEmail) {
                throw new BusinessException("this email already exists");
            }
            Users user = new Users()
                    .setName(dto.getUsername())
                    .setEmail(dto.getEmail())
                    .setPassword(passwordHash);
            usersRepository.create(user);

            return user;

        });
    }

}
