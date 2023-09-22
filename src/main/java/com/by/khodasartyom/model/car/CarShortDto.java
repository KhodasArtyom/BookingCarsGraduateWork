package com.by.khodasartyom.model.car;

import com.by.khodasartyom.model.admin.AdminShortDto;
import lombok.Value;

@Value
public class CarShortDto {
    long id;
    AdminShortDto adminShortDto;
    String brand;

    public static CarShortDto from(Car car) {

        return new CarShortDto(
                car.getId(),
                AdminShortDto.from(car.getAdmin()),
                car.getBrand()
        );
    }
}
