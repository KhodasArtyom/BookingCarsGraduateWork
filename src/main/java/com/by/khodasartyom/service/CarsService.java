package com.by.khodasartyom.service;

import com.by.khodasartyom.dto.CarsDto;
import com.by.khodasartyom.entity.cars.Cars;
import com.by.khodasartyom.exception.BusinessException;

import java.util.List;

public interface CarsService {

    public void createNewCar(CarsDto cars);

    public void removeCar(CarsDto cars);

    List<Cars> findByBrand(String brand);

    List<Cars> getCarsByBrandAndModel(String brand,String model);

    List<Cars> findByYearOfIssue(int yearOfIssue);

    List<Cars> findByAvailabilityTrue();



}
