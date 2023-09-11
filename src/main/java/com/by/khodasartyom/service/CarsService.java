package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CarsService {
    List<CarsDto> getCarsByBrand(String brand);
    List<CarsDto> getCarsByBrandAndModel(String brand, String model);
    List<CarsDto> getCarsByYearOfIssue(int yearOfIssue);
}
