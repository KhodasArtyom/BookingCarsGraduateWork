package com.by.khodasartyom.model.entityandDto.users;

import lombok.Value;

@Value
public class UserDto {

    String username;
    String password;
    String email;

    public static UserDto from(User user){

        return new UserDto(user.getName(),
                user.getPasswordHash(),
                user.getEmail());
    }
}
