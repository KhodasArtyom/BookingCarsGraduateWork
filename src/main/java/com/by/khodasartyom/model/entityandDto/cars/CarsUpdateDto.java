package com.by.khodasartyom.model.entityandDto.cars;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CarsUpdateDto {

    String brand;
    String model;
    Integer year_of_issue;
    BigDecimal price;
    boolean status;
}
