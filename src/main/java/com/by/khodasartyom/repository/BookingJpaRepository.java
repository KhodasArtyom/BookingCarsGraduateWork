package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.booking.Booking;

import java.util.Date;
import java.util.List;

public class BookingJpaRepository extends BaseJpaRepository<Booking,Long> implements BookingRepository{
    public BookingJpaRepository() {
        super(Booking.class);
    }

    @Override
    public List<Booking> findByUserId(Long userId) {
        return entityManager.createQuery("""
                        SELECT b FROM Booking b
                        WHERE b.user.id = :userId
                        """,Booking.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    @Override
    public List<Booking> findByCarId(Long carId) {
        return entityManager.createQuery("""
                        SELECT b FROM Booking b
                        WHERE b.car.id = :carId
                        """,Booking.class)
                .setParameter("userId",carId)
                .getResultList();
    }

    @Override
    public List<Booking> fndByStartDateBetween(Date startDate, Date endDate) {
        return entityManager.createQuery("""
                        SELECT b FROM Booking b
                        WHERE b.start_date BETWEEN :startDate AND :endDate
                        """,Booking.class)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
