package com.by.khodasartyom.model.user;

import lombok.Value;

@Value
public class UserSignUpDto {
    String name;
    String email;
    String password;
}
