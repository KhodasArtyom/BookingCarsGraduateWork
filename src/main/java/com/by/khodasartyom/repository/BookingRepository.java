package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.booking.Booking;
import com.by.khodasartyom.model.entityandDto.users.Users;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends BaseRepository<Booking,Long> {

    List<Booking> findByUser(Users user);

    List<Booking> findByStartDateAfter(LocalDate startDate);

    List<Booking> findByEndDateBefore(LocalDate endDate);




}
