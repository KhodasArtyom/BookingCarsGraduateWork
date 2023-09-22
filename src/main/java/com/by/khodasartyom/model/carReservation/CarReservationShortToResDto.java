package com.by.khodasartyom.model.carReservation;

import lombok.Value;

import java.time.Instant;
import java.time.LocalDate;

@Value
public class CarReservationShortToResDto {
    long id;
    String message;
    LocalDate startDate;
    LocalDate endDate;
    Instant createdAt;

    public static CarReservationShortToResDto from(CarReservation carReservation){

        return new CarReservationShortToResDto(
                carReservation.getId(),
                carReservation.getMessage(),
                carReservation.getStartDate(),
                carReservation.getEndDate(),
                carReservation.getCreatedAt()
        );
    }
}
