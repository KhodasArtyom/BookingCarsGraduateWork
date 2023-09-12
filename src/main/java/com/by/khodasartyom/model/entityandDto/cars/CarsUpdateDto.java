package com.by.khodasartyom.model.entityandDto.cars;


import lombok.Value;

import java.math.BigDecimal;

@Value
public class CarsUpdateDto {

    String brand;
    String model;
    BigDecimal price;
    boolean bookingStatus;
}
