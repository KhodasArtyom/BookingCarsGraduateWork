package com.by.khodasartyom.service;

import com.by.khodasartyom.model.car.CarDto;
import com.by.khodasartyom.model.car.CarUpdateDto;
import com.by.khodasartyom.model.carReservation.CarReservationDto;
import com.by.khodasartyom.model.security.AdminPrincipal;

import java.util.List;

public interface CarAdminService {

    CarDto getCarById(long id, AdminPrincipal adminPrincipal);

    CarDto create(CarUpdateDto dto,AdminPrincipal adminPrincipal);

    CarDto update(long id,CarUpdateDto dto,AdminPrincipal adminPrincipal);

    List<CarDto> getPageOfCars(int pageNumber,AdminPrincipal adminPrincipal);

    List<CarReservationDto> getCarReservationListWithCarsAndUsers(int pageNumber,AdminPrincipal adminPrincipal);
}
