package com.by.khodasartyom.model.security;

import com.by.khodasartyom.model.entityandDto.users.Users;
import lombok.Value;

@Value
public class UserPrincipal implements AccountPrincipal{

    long id;

    @Override
    public Role getRole() {
        return Role.USER;
    }

    public static UserPrincipal from(Users user) {
        return new UserPrincipal(user.getUsers_id());
    }
}
