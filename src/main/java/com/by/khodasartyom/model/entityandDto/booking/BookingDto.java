package com.by.khodasartyom.model.entityandDto.booking;

import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.model.entityandDto.users.UserDto;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BookingDto {
    Long booking_id;
    CarsDto car;
    UserDto user;
    LocalDateTime startOfLease;
    LocalDateTime endOfLease;

    public static BookingDto from(Booking booking) {

        return new BookingDto(booking.getId_booking(),
                CarsDto.from(booking.getCar()),
                UserDto.from(booking.getUser()),
                booking.getStart_of_lease(),
                booking.getEnd_of_lease());

    }

}
