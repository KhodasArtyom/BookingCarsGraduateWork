package com.by.khodasartyom.model.entityandDto.booking;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.model.entityandDto.users.User;
import com.by.khodasartyom.model.entityandDto.users.UserDto;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class BookingDto {

    long id;
    CarsDto car;
    UserDto user;
    LocalDate startDate;
    LocalDate endDate;
    BigDecimal totalPrice;
    String reservationStatus;

    public static BookingDto from(Booking booking) {

        return new BookingDto(booking.getId(),
                CarsDto.from(booking.getCar()),
                UserDto.from(booking.getUser()),
                        booking.getStart_of_lease(),
                        booking.getEnd_date(),
                        booking.getTotalPrice(),
                        booking.getReservationStatus());
    }





}
