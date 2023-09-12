package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarsJpaRepository extends BaseJpaRepository<Cars, Long> implements CarsRepository {


    public CarsJpaRepository() {
        super(Cars.class);
    }

    @Override
    public List<Cars> findAllCarsByBrand(String brand,int pageSize,int pageNumber) {
        return entityManager.createQuery("""
                        SELECT cars.brand
                        FROM  Cars cars
                        WHERE cars.brand = :brand AND cars.bookingStatus=TRUE
                        ORDER BY cars.brand ASC
                        """, Cars.class)
                .setParameter("brand", brand)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize* pageNumber)
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
    public List<Cars> getAllCars(int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT cars
                        FROM Cars cars
                        """, Cars.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();

    }


}





