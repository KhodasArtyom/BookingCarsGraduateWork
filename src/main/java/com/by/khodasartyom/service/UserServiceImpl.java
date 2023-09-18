package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.entityandDto.users.User;
import com.by.khodasartyom.model.entityandDto.users.UserSignInDto;
import com.by.khodasartyom.model.entityandDto.users.UserSignUpDto;
import com.by.khodasartyom.repository.UserRepository;
import com.by.khodasartyom.security.AccessToken;
import com.by.khodasartyom.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.support.TransactionOperations;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccessTokenService accessTokenService;
    private final PasswordEncoder passwordEncoder;
    private final TransactionOperations txOps;

    @Override
    public AccessToken signIn(UserSignInDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(()->new BadCredentialsException("User is nit found"));

        if(!passwordEncoder.matches(dto.getPassword(),user.getPasswordHash())){
            throw new BadCredentialsException("Error");
        }
        UserPrincipal principal = UserPrincipal.from(user);


        return accessTokenService.generate(principal);
    }

    @Override
    public AccessToken signUp(UserSignUpDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        User user = create(dto,passwordHash);
        UserPrincipal principal = UserPrincipal.from(user);

        return accessTokenService.generate(principal);
    }


    private User create(UserSignUpDto dto,String passwordHash){

        return txOps.execute(tx->{
            boolean existByEmail = userRepository.findByEmail(dto.getEmail()).isPresent();
            if(existByEmail){
                throw new BusinessException("User doesn't exist");
            }
            User user = new User()
                    .setEmail(dto.getEmail())
                    .setName(dto.getName())
                    .setPasswordHash(passwordHash);
            userRepository.create(user);
                    return user;
                }
        );
    }
}
