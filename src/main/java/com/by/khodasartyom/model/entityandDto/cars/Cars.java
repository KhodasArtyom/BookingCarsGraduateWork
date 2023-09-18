package com.by.khodasartyom.model.entityandDto.cars;

import com.by.khodasartyom.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


@Entity
@Table(name = "cars")
@Getter
@Setter
@Accessors(chain = true)
public class Cars extends BaseEntity {



    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "year_of_issue",nullable = false)
    private Integer year_of_issue;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Column(name = "booking_status",nullable = false)
    private boolean bookingStatus;





}
