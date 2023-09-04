package com.by.khodasartyom.entity.cars;

import com.by.khodasartyom.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Cars extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cars;

    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "year_of_issue",nullable = false)
    private int year_of_issue;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Column(name = "availability",nullable = false)
    private boolean availability;

}
