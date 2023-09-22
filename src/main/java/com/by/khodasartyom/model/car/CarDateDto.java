package com.by.khodasartyom.model.car;

import com.by.khodasartyom.model.admin.AdminShortDto;
import lombok.Value;

@Value
public class CarDateDto {
    long id;
    AdminShortDto adminShortDto;
    String brand;
    boolean statusActive;


    public static CarDateDto from(Car car){

        return new CarDateDto(
                car.getId(),
                AdminShortDto.from(car.getAdmin()),
                car.getBrand(),
                car.isActive_status()
        );
    }
}
