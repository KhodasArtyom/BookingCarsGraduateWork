package com.by.khodasartyom.model.entityandDto.users;

import com.by.khodasartyom.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;




@Entity
@Table(name="users")
@Getter
@Setter
@Accessors(chain = true)
public class User extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name = "password_hash",nullable = false)
    private String passwordHash;


}
