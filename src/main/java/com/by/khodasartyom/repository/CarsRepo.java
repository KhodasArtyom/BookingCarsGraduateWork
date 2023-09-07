package com.by.khodasartyom.repository;

import com.by.khodasartyom.entity.cars.Cars;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CarsRepo extends BaseRepository<Cars,Long> {



    List<Cars> findByBrand(String brand);

    List<Cars> findByBrandAndModel(String brand,String model);

    List<Cars> findByYearOfIssue(int yearOfIssue);

    List<Cars> findByAvailabilityTrue();







}
