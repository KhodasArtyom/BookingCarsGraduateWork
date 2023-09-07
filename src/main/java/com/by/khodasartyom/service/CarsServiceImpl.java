package com.by.khodasartyom.service;

import com.by.khodasartyom.dto.CarsDto;
import com.by.khodasartyom.entity.cars.Cars;
import com.by.khodasartyom.repository.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService{
    private CarsRepo carsRepo;


    @Autowired
    public CarsServiceImpl(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }

    @Override
    @Transactional
    public void createNewCar(CarsDto car) {

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
