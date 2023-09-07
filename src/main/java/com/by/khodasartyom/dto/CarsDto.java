package com.by.khodasartyom.dto;

import com.by.khodasartyom.entity.cars.Cars;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class CarsDto {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private Long price;


    public static CarsDto from(Cars car) {
        return new CarsDto(car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getYear_of_issue(),
                car.getPrice());
    }
}
