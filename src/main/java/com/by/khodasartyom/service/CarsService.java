package com.by.khodasartyom.service;

import com.by.khodasartyom.model.dto.CarsDto;
import com.by.khodasartyom.model.entityandDto.cars.Cars;

import java.util.List;

public interface CarsService {

    public List findAllCars();

    public void createNewCar(CarsDto cars);

    public void removeCar(CarsDto cars);

    List<Cars> findByBrand(String brand);

    List<Cars> getCarsByBrandAndModel(String brand,String model);

    List<Cars> findByYearOfIssue(int yearOfIssue);

    List<Cars> findByAvailabilityTrue();



}
