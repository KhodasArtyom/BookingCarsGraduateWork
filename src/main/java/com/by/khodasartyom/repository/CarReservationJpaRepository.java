package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.carReservation.CarReservation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CarReservationJpaRepository extends BaseJpaRepository<CarReservation,Long> implements CarReservationRepository{
    public CarReservationJpaRepository() {
        super(CarReservation.class);
    }

    @Override
    public Optional<CarReservation> findByCarAndUser(long carId, long userId) {
        return entityManager.createQuery("""
SELECT carReservation
FROM CarReservation carReservation
WHERE carReservation.car.id = :carId
AND carReservation.user.id=:userId
""",CarReservation.class)
                .setParameter("carId",carId)
                .setParameter("userId",userId)
                .getResultStream()
                .findFirst();
    }

    @Override
    public List<CarReservation> findByCarAdminAndUser(long adminId, long userId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT carReservation
                        FROM CarReservation carReservation
                        WHERE carReservation.car.admin.id=:adminId
                        AND carReservation.user.id = :userId
                        ORDER BY carReservation.createdAt DESC
                        """,CarReservation.class)
                .setParameter("adminId",adminId)
                .setParameter("userId",userId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize*pageNumber)
                .getResultList();
    }

    @Override
    public List<CarReservation> findPageByUser(long userId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT carReservation
                        FROM CarReservation carReservation
                        WHERE carReservation.user.id=:userId
                        ORDER BY carReservation.createdAt DESC
                        """,CarReservation.class)
                .setParameter("userId",userId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize*pageNumber)
                .getResultList();
    }

    @Override
    public List<CarReservation> findPageByAdminWithCarAndUser(long adminId, int pageSize, int pageNumber) {
        return entityManager.createQuery("""
                        SELECT carReservation
                        FROM CarReservation carReservation
                        JOIN FETCH carReservation.car
                        JOIN FETCH carReservation.user
                        WHERE carReservation.car.id=:adminId
                        ORDER BY carReservation.createdAt DESC 
                        """,CarReservation.class)
                .setParameter("adminId",adminId)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize*pageNumber)
                .getResultList();
    }
}
