package com.by.khodasartyom.model.entityandDto.cars;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CarsDto {

    long id;
    String brand;
    String model;
    Integer year_of_issue;
    BigDecimal price;
    Boolean reservation_status;

    public static CarsDto from(Cars car) {

        return new CarsDto(car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getYear_of_issue(),
                car.getPrice(),
                car.isBookingStatus());
    }
}
