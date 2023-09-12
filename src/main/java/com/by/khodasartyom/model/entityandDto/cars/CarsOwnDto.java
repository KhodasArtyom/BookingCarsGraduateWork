package com.by.khodasartyom.model.entityandDto.cars;

import lombok.Value;

import java.math.BigDecimal;
@Value
public class CarsOwnDto {
    long id;
    String brand;
    String model;
    Integer year;
    BigDecimal price;
    boolean status_of_booking;

    public static CarsOwnDto from(Cars car){
        return new CarsOwnDto(car.getId_cars(),
                car.getBrand(),
                car.getModel(),
                car.getYear_of_issue(),
                car.getPrice(),
                car.isBookingStatus());
    }

}
