package com.by.khodasartyom.entity.booking;


import com.by.khodasartyom.entity.BaseEntity;
import com.by.khodasartyom.entity.cars.Cars;
import com.by.khodasartyom.entity.users.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_booking;

    @ManyToOne
    @JoinColumn(name = "id_cars",referencedColumnName = "id_cars",nullable = false)
    private Cars car;

    @ManyToOne
    @JoinColumn(name = "id_users",referencedColumnName = "id_users" ,nullable = false)
    private Users user;

    @Column(name = "start_of_lease",nullable = false)
    private LocalDateTime start_of_lease;

    @Column(name = "end_of_lease",nullable = false)
    private LocalDateTime end_of_lease;


    @Column(name = "status",nullable = false)
    private String status;








}
