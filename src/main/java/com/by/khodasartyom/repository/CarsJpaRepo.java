package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarsJpaRepo implements CarsRepo {

    private EntityManager entityManager;

    @Override
    public List<Cars> findAll() {
        return entityManager.createQuery("""
                        SELECT cars FROM Cars cars
                        """, Cars.class)
                .getResultList();
    }

    @Override
    public Iterable<Cars> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Cars entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cars> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Cars> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Cars> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Cars> findById(Long id) {
        Cars car = entityManager.find(Cars.class, id);
        return Optional.ofNullable(car);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
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


}





