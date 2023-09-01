package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.Cars;

import java.util.List;
import java.util.Optional;

public class CarsJpaRepo extends BaseJPARepository<Cars, Long> implements CarsRepo {


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
    public List<Cars> findByYear(int year) {
        return entityManager.createQuery("""
                        SELECT cars.year_of_issue FROM Cars cars
                        WHERE cars.year_of_issue = :year_of_issue
                        """,Cars.class)
                .setParameter("year",year)
                .getResultList();
    }

    @Override
    public List<Cars> findByAvailability(boolean availability) {
        return entityManager.createQuery("""
                        SELECT cars.availability FROM Cars cars
                        WHERE cars.availability = :availability
                        """,Cars.class)
                .setParameter("availability",availability)
                .getResultList();
    }

    @Override
    public void create(Cars entity) {
        super.create(entity);
    }

    @Override
    public void remove(Cars entity) {
        super.remove(entity);
    }
}
