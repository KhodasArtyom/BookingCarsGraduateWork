package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;

import java.util.List;

public class CarsJpaRepository extends BaseJpaRepository<Cars, Long> implements CarRepository {

    public CarsJpaRepository() {
        super(Cars.class);
    }

    @Override
    public List<Cars> findAllCars() {

        return entityManager.createQuery("""
                        SELECT cars
                        FROM Cars cars
                        """, Cars.class)
                .getResultList();
    }

    @Override
    public List<Cars> findByBrand(String brand) {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        WHERE cars.brand = :brand
                        """,Cars.class)
                .setParameter("brand",brand)
                .getResultList();
    }

    @Override
    public List<Cars> findByModel(String model) {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        WHERE cars.model = :model
                        """,Cars.class)
                .setParameter("model",model)
                .getResultList();
    }

    @Override
    public List<Cars> findByYear(Integer year_of_issue) {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        WHERE cars.year_of_issue = :year_of_issue
                        """,Cars.class)
                .setParameter("year_of_issue",year_of_issue)
                .getResultList();
    }

    @Override
    public List<Cars> findByYearGreaterThan(Integer year_of_issue) {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        WHERE cars.year_of_issue > year_of_issue
                        """,Cars.class)
                .setParameter("year_of_issue",year_of_issue)
                .getResultList();
    }


}
