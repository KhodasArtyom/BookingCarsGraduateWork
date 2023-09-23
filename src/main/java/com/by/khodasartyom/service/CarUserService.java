package com.by.khodasartyom.service;

import com.by.khodasartyom.model.car.CarDateDto;
import com.by.khodasartyom.model.car.CarPriceDto;
import com.by.khodasartyom.model.car.CarShortDto;
import com.by.khodasartyom.model.carReservation.CarReservationCreateReservationDto;
import com.by.khodasartyom.model.carReservation.CarReservationShortToResDto;
import com.by.khodasartyom.model.security.UserPrincipal;

import java.time.LocalDate;
import java.util.List;

public interface CarUserService {

    List<CarShortDto> getPageByBrandQuery(String brandQuery,int pageNumber);

    List<CarPriceDto> findPageActiveStatusWithLowPrice(UserPrincipal userPrincipal,int pageNumber);

    List<CarDateDto> getAvailableCarsOnUserDate(LocalDate startDate,LocalDate endDate,UserPrincipal userPrincipal,int pageNumber);

    CarReservationShortToResDto sendRequestForReservation(CarReservationCreateReservationDto dto,UserPrincipal userPrincipal);
}
