package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;

import java.util.List;

public interface CarRepository extends BaseRepository<Cars,Long>{

    List<Cars> findAllCars();

    List<Cars> findByBrand(String brand);

    List<Cars> findByModel(String model);

    List<Cars> findByYear(Integer year);

    List<Cars> findByYearGreaterThan(Integer year);
}
