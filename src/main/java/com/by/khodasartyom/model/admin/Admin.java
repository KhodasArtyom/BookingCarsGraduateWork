package com.by.khodasartyom.model.admin;

import com.by.khodasartyom.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Entity
@Table(name="admin")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Admin extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password_hash",nullable = false)
    private String passwordHash;
}
