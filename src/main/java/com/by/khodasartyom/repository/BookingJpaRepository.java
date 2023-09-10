package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.booking.Booking;
import com.by.khodasartyom.model.entityandDto.users.Users;

import java.time.LocalDate;
import java.util.List;


public class BookingJpaRepository extends BaseJpaRepository<Booking, Long> implements BookingRepository {
    public BookingJpaRepository(Class<BookingRepository> bookingRepositoryClass) {
        super(Booking.class);
    }

    @Override
    public List<Booking> findByUser(Users user) {
        return entityManager.createQuery("""
                        SELECT booking
                        FROM Booking booking
                        WHERE booking.user=:user
                        """, Booking.class)
                .setParameter("user", user)
                .getResultList();
    }


    @Override
    public List<Booking> findByStartDateAfter(LocalDate startDate) {
        return entityManager.createQuery("""
                        SELECT booking
                        FROM Booking booking
                        WHERE booking.start_of_lease > :startDate
                        """, Booking.class)
                .setParameter("startDate", startDate)
                .getResultList();
    }

    @Override
    public List<Booking> findByEndDateBefore(LocalDate endDate) {
        return entityManager.createQuery("""
                        SELECT booking
                        FROM Booking booking
                        WHERE booking.start_of_lease < :endDate
                        """, Booking.class)
                .setParameter("endDate", endDate)
                .getResultList();
    }


}
