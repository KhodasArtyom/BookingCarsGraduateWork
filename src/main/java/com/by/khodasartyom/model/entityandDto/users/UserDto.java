package com.by.khodasartyom.model.entityandDto.users;

import lombok.Value;


@Value
public class UserDto
{
     String username;

     String email;

     String password;

    public static UserDto from(Users user) {
        return new UserDto(
                user.getName(),
                user.getEmail(),
                user.getPassword());
    }


}
