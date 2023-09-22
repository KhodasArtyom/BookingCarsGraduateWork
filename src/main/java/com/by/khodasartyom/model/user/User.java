package com.by.khodasartyom.model.user;

import com.by.khodasartyom.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.Accessors;

@Entity
@Table(name = "user")
@Getter
@Setter
@Accessors(chain = true)
public class User extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name = "password_hash",nullable = false)
    private String passwordHash;
}
