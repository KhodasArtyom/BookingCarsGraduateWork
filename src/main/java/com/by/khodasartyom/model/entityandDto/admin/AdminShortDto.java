package com.by.khodasartyom.model.entityandDto.admin;

import lombok.Value;

@Value
public class AdminShortDto {
    long id;
    String name;
    String email;

    public static AdminShortDto from(Admin admin) {
        return new AdminShortDto(
                admin.getId(),
                admin.getName(),
                admin.getEmail());
    }

}
