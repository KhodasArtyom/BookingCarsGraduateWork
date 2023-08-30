package com.by.khodasartyom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manager")
@Getter
@Setter
@NoArgsConstructor
public class Manager extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manager_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

}
