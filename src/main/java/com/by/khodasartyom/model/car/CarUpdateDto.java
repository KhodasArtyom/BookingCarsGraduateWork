package com.by.khodasartyom.model.car;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CarUpdateDto {

    String brand;
    String model;
    BigDecimal price;
    boolean statusActive;
}
