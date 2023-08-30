package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.Cars;

import java.util.Optional;

public class CarsJpaRepo extends BaseJPARepository<Cars,Long> implements CarsRepo{


    public CarsJpaRepo() {
        super(Cars.class);
    }

//    @Override
//    public Optional<Cars> findById(Long id) {
//        return entityManager.createQuery("""
//                SELECT
//
//                """);
//    }
}
