package com.by.khodasartyom.model.entityandDto.cars;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CarsPriceDto {
    long id;
    String brand;
    String model;
    Integer year_of_Issue;
    BigDecimal price;

    public static CarsPriceDto from(Cars car){

        return new CarsPriceDto(car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getYear_of_issue(),
                car.getPrice());
    }

}
