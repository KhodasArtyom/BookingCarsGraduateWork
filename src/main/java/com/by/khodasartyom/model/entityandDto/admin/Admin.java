package com.by.khodasartyom.model.entityandDto.admin;

import com.by.khodasartyom.model.entityandDto.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Entity
@Getter
@Setter
@Table(name = "admin")
@Accessors(chain = true)
public class Admin extends BaseEntity {
    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password_hash",nullable = false,unique = true)
    private String passwordHash;
}
