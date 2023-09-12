package com.by.khodasartyom.model.entityandDto.cars;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CarsDto {
    Long id_cars;

    String brand;

    String model;

    Integer year_of_issue;

    BigDecimal price;

    public static CarsDto from(Cars car) {
        return new CarsDto(
                car.getId_cars(),
                car.getBrand(),
                car.getModel(),
                car.getYear_of_issue(),
                car.getPrice());
    }

}
