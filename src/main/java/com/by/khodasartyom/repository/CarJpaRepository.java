package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.car.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class CarJpaRepository extends BaseJpaRepository<Car, Long> implements CarRepository {

    public CarJpaRepository() {
        super(Car.class);
    }

    @Override
    public List<Car> findPageByAdmin(long adminId, int pageSize, int pageNumber) {

        return entityManager.createQuery("""
                        SELECT car
                        FROM Car car
                        WHERE car.admin.id=:admin
                        ORDER BY car.createdAt DESC 
                        """, Car.class)
                .setParameter("adminId", adminId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Car> findPageActiveCarByLowPrice(int pageSize, int pageNumber) {

        return entityManager.createQuery("""
                        SELECT car
                        FROM Car car
                        WHERE car.active_status=TRUE
                        ORDER BY car.price ASC
                        """, Car.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Car> getAvailableCarsInDateRange(LocalDate startDate, LocalDate endDate, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT car
                        FROM Car car
                        WHERE car.active_status = TRUE
                        AND car NOT IN
                        (SELECT carReservation.car
                        FROM CarReservation carReservation
                        WHERE carReservation.endDate>=:startDate
                        AND carReservation.startDate<=:endDate) 
                        """, Car.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }

    @Override
    public List<Car> findPageOfActiveAdminsCarsByBrand(String brand, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT car
                        FROM Car car
                        JOIN FETCH car.admin
                        WHERE car.active_status
                        AND car.brand ILIKE :brand
                        ORDER BY car.createdAt DESC 
                        """, Car.class)
                .setParameter("brand", brand)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
