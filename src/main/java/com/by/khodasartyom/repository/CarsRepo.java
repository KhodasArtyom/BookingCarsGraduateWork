package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.Cars;

import java.util.List;
import java.util.Optional;

public interface CarsRepo extends BaseRepository<Cars, Long> {

    @Override
    Optional<Cars> findById(Long id);

    List<Cars> findByBrand(String brand);

    List<Cars> findByYear(int year);

    List<Cars> findByAvailability(boolean availability);

    @Override
    void create(Cars entity);

    @Override
    void remove(Cars entity);
}
