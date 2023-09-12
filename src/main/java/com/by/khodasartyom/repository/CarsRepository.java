package com.by.khodasartyom.repository;


import com.by.khodasartyom.model.entityandDto.cars.Cars;

import java.util.List;

public interface CarsRepository extends  BaseRepository<Cars, Long>{

    List<Cars> findByBrand(String brand);

    List<Cars> findByBrandAndModel(String brand, String model);

    List<Cars> findByYearOfIssue(int yearOfIssue);

    List<Cars> getAllCars(int pageSize,int pageNumber);



}
