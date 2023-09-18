package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.booking.Booking;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends BaseRepository<Booking,Long>{

    List<Booking> findByUserId(Long id);

    List<Booking> findByCarId(Long id);

    List<Booking> fndByStartDateBetween(Date startDate, Date endDate);
}
