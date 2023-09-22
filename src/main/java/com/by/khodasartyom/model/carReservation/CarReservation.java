package com.by.khodasartyom.model.carReservation;

import com.by.khodasartyom.model.BaseEntity;
import com.by.khodasartyom.model.car.Car;
import com.by.khodasartyom.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "car_reservation")
@Getter
@Setter
@Accessors(chain = true)
public class CarReservation extends BaseEntity {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "start_date", columnDefinition = "DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date",columnDefinition = "DATE",nullable = false)
    private LocalDate endDate;

    @Column(name = "created-at",nullable = false)
    private Instant createdAt;


}
