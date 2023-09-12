package com.by.khodasartyom.model.entityandDto.booking;


import com.by.khodasartyom.model.entityandDto.BaseEntity;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.users.Users;
import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@Setter
@Accessors(chain = true)
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_booking;

    @ManyToOne
    @JoinColumn(name = "id_cars", referencedColumnName = "id_cars", nullable = false)
    private Cars car;

    @ManyToOne
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", nullable = false)
    private Users user;

    @Column(name = "start_of_lease", nullable = false)
    private LocalDateTime start_of_lease;

    @Column(name = "end_of_lease", nullable = false)
    private LocalDateTime end_of_lease;


    @Column(name = "price", nullable = false)
    private BigDecimal price;


}
