package com.by.khodasartyom.dto;

import com.by.khodasartyom.entity.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private UsersDto user;
    private CarsDto car;

    public static BookingDto from(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setCar(CarsDto.from(booking.getCar()));
        bookingDto.setUser(UsersDto.from(booking.getUser()));
        bookingDto.setStartDate(booking.getStart_of_lease());
        bookingDto.setEndDate(booking.getEnd_of_lease());
        return bookingDto;
    }


}

