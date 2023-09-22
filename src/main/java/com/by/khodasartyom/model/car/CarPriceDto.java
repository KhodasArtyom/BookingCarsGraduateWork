package com.by.khodasartyom.model.car;

import com.by.khodasartyom.model.admin.AdminShortDto;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class CarPriceDto {

    long id;
    AdminShortDto adminShortDto;
    String brand;
    boolean statusActive;
    BigDecimal price;

    public static CarPriceDto from(Car car){

        return new CarPriceDto(
                car.getId(),
                AdminShortDto.from(car.getAdmin()),
                car.getBrand(),
                car.isActive_status(),
                car.getPrice());
    }
}
