package com.by.khodasartyom.model.user;

import lombok.Value;

@Value
public class UserDto {

    String email;
    String name;

    public static UserDto from(User user){

        return new UserDto(user.getEmail(),user.getName());
    }
}
