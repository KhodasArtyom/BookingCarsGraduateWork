package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CarsRepo extends CrudRepository<Cars,Long> {



    List<Cars> findByBrand(String brand);

    List<Cars> findByBrandAndModel(String brand,String model);

    List<Cars> findByYearOfIssue(int yearOfIssue);









}
