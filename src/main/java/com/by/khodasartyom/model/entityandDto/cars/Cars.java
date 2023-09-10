package com.by.khodasartyom.model.entityandDto.cars;

import com.by.khodasartyom.model.entityandDto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "cars")
@Getter
@Setter

public class Cars extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cars;

    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "year_of_issue",nullable = false)
    private Integer year_of_issue;

    @Column(name = "price",nullable = false)
    private Long price;



}
