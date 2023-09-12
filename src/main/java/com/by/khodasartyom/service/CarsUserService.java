package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.booking.BookingDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsShortDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CarsUserService {


    List<CarsDto> seeAllCars(int pageNumber);

    Optional<CarsShortDto> getCarById(long id);

    List<CarsShortDto> getListOfCarsByBrand(String brand,int pageNumber);

    BookingDto bookCar(Long userId, Long carId, LocalDateTime startOfLease,LocalDateTime endOfLease);







}
