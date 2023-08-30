package com.by.khodasartyom.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long users_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "name",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;



}