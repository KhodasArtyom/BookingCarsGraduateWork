package com.by.khodasartyom.model.entityandDto.cars;

import com.by.khodasartyom.model.entityandDto.admin.AdminShortDto;
import lombok.Value;

@Value
public class CarsShortDto {
    long id;

    AdminShortDto adminShortDto;

    String brand;

    String model;


    public static CarsShortDto from(Cars car) {

        return new CarsShortDto(car.getId(),
                AdminShortDto.from(car.getAdmin()),
                car.getBrand(),
                car.getModel());
    }

    ;


}
