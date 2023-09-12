package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsOwnDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsUpdateDto;
import com.by.khodasartyom.model.security.AdminPrincipal;

import java.util.List;


public interface CarsAdminService {
CarsOwnDto createCar(CarsUpdateDto dto,AdminPrincipal adminPrincipal);

CarsOwnDto updateInfoAboutCar(long id,CarsUpdateDto carsUpdateDto,AdminPrincipal adminPrincipal);

CarsOwnDto getCarsOwnById(long id,AdminPrincipal adminPrincipal);

List<CarsDto> getPageOwnCars(int pageNumber);

void deleteTheCar(long id,AdminPrincipal adminPrincipal);

}
