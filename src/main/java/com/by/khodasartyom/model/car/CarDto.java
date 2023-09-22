package com.by.khodasartyom.model.car;

import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;

@Value
public class CarDto {
    long id;
    String brand;
    String model;
    BigDecimal price;
    boolean statusActive;
    Instant createdAd;

    public static CarDto from(Car car){
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPrice(),
                car.isActive_status(),
                car.getCreatedAt()
        );
    }
}
