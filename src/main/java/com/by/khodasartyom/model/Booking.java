package com.by.khodasartyom.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_booking;

    @ManyToOne
    @JoinColumn(name = "id_cars")
    private Cars car;

    @ManyToOne
    @JoinColumn(name = "id_users",nullable = false)
    private Users user;

    @Column(name = "begin_status",nullable = false)
    private LocalDateTime begin_status;

    @Column(name = "end_status",nullable = false)
    private LocalDateTime end_status;


    @Column(name = "status",nullable = false)
    private String status;








}
