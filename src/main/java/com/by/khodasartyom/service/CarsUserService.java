package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.cars.CarsShortDto;

import java.util.List;

public interface CarsUserService {

    List<CarsShortDto> seeAllCars(int pageNumber);



}
