package com.by.khodasartyom.dto;

import com.by.khodasartyom.entity.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Long id;
    private String name;
    private String email;


    public static UsersDto from(Users user) {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(user.getId());
        usersDto.setName(user.getName());
        usersDto.setEmail(user.getEmail());
        return usersDto;
    }

}
