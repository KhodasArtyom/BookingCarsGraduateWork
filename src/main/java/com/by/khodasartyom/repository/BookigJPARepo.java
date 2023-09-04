package com.by.khodasartyom.repository;

import com.by.khodasartyom.entity.booking.Booking;

import java.util.Date;
import java.util.List;

public class BookigJPARepo extends BaseJPARepository<Booking, Long> implements BookingRepo {
    public BookigJPARepo() {
        super(Booking.class);
    }

    @Override
    public List<Booking> findByUserId(Long userId) {
        return entityManager.createQuery("""
                        SELECT booking FROM Booking booking
                        WHERE booking.user.id = :userId
                        """, Booking.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Booking> findByCarId(Long carId) {
        return entityManager.createQuery("""
                        SELECT booking FROM Booking booking
                        WHERE booking.car.id = :carId
                        """, Booking.class)
                .setParameter("carId ", carId)
                .getResultList();
    }

    @Override
    public List<Booking> findByStartDateBetween(Date startDate, Date endDate) {

        return entityManager.createQuery("""
                        SELECT booking FROM Booking booking
                        WHERE booking.start_of_lease BETWEEN  :startDate AND :endDate
                        """, Booking.class)
                .setParameter("start_of_lease", startDate)
                .setParameter("end_of_lease", endDate)
                .getResultList();
    }



    @Override
    public Booking getReferenceById(Long id)
    {
        return entityManager.getReference(Booking.class,id);
    }
}
