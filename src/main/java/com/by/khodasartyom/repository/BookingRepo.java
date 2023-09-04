package com.by.khodasartyom.repository;

import com.by.khodasartyom.entity.booking.Booking;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends BaseRepository<Booking,Long>{

    public List<Booking> findByUserId(Long userId);

    public List<Booking> findByCarId(Long carId);

    public List<Booking> findByStartDateBetween(Date startDate, Date endDate);


    Booking getReferenceById(Long aLong);
}
