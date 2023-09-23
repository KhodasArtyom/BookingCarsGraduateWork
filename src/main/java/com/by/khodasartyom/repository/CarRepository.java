package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.car.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends BaseRepository<Car,Long> {

    List<Car> findPageByAdmin(long adminId,int pageSize,int pageNumber);

    List<Car> findPageActiveCarByLowPrice(int pageSize,int pageNumber);

    List<Car> getAvailableCarsInDateRange(LocalDate startDate,LocalDate endDate,int pageSize,int pageNumber);

    List<Car> findPageOfActiveAdminsCarsByBrand(String brand,int pageSize,int pageNumber);
}
