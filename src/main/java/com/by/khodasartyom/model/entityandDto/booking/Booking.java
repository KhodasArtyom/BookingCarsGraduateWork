package com.by.khodasartyom.model.entityandDto.booking;


import com.by.khodasartyom.model.entity.BaseEntity;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.users.User;
import jakarta.persistence.*;

import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "car_reservation")
@Getter
@Setter

@Accessors(chain = true)
public class Booking extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id_car", nullable = false)
    private Cars car;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_users", nullable = false)
    private User user;

    @Column(name = "start_date", nullable = false)
    private LocalDate start_date;

    @Column(name = "end_date", nullable = false)
    private LocalDate end_date;

    @Column(name = "totalPrice",nullable = false)
    private BigDecimal totalPrice;


    @Column(name = "reservation_status",nullable = false)
    private String reservationStatus;


}
