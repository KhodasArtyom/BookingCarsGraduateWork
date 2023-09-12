package com.by.khodasartyom.model.security;

import com.by.khodasartyom.model.entityandDto.admin.Admin;
import lombok.Value;

@Value
public class AdminPrincipal implements AccountPrincipal{

    long id;


    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    public static AdminPrincipal from(Admin admin) {
        return new AdminPrincipal(admin.getId());
    }
}
