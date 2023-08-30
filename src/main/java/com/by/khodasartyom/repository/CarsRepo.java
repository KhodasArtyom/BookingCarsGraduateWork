package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.Cars;

import java.util.Optional;

public interface CarsRepo extends BaseRepository<Cars,Long>{

    @Override
    Optional<Cars> findById(Long id);
}
