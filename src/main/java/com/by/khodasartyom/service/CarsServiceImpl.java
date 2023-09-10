package com.by.khodasartyom.service;

import com.by.khodasartyom.model.dto.CarsDto;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.repository.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService{
    private final CarsRepo carsRepo;


    @Autowired
    public CarsServiceImpl(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }


    @Override
    public List findAllCars() {
        return null;
    }

    @Override
    public void createNewCar(CarsDto cars) {

    }


    @Override
    public void removeCar(CarsDto cars) {

    }

    @Override
    public List<Cars> findByBrand(String brand) {
        return null;
    }

    @Override
    public List<Cars> getCarsByBrandAndModel(String brand, String model) {
        return null;
    }

    @Override
    public List<Cars> findByYearOfIssue(int yearOfIssue) {
        return null;
    }

    @Override
    public List<Cars> findByAvailabilityTrue() {
        return null;
    }
}
