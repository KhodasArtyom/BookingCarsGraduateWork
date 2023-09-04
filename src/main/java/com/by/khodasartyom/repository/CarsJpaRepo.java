package com.by.khodasartyom.repository;

import com.by.khodasartyom.entity.cars.Cars;

import java.util.List;
import java.util.Optional;

public class CarsJpaRepo extends BaseJPARepository<Cars, Long> implements CarsRepository {


    public CarsJpaRepo() {
        super(Cars.class);
    }

    @Override
    public Optional<Cars> findById(Long id) {
        Cars car = entityManager.find(Cars.class, id);

        return Optional.ofNullable(car);
    }

    @Override
    public List<Cars> findByBrand(String brand) {
        return entityManager.createQuery("""
                        SELECT cars.brand FROM  Cars cars
                        WHERE cars.brand = :brand
                        ORDER BY cars.brand ASC
                        """, Cars.class)
                .setParameter("brand", brand)
                .getResultList();
    }

    @Override
    public List<Cars> findByBrandAndModel(String brand, String model) {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        WHERE cars.brand = :brand AND cars.model = :model
                        """, Cars.class)
                .setParameter("brand", brand)
                .setParameter("model", model)
                .getResultList();
    }

    @Override
    public List<Cars> findByYearOfIssue(int yearOfIssue) {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        WHERE cars.year_of_issue = :year_of_issue
                        """, Cars.class)
                .setParameter("year_of_issue", yearOfIssue)
                .getResultList();
    }

    @Override
    public List<Cars> findByAvailabilityTrue() {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        WHERE cars.availability = TRUE
                        """, Cars.class)
                .getResultList();
    }


}
