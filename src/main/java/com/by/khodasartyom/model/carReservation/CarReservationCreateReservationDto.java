package com.by.khodasartyom.model.carReservation;

import lombok.Value;

import java.time.LocalDate;

@Value
public class CarReservationCreateReservationDto {
    long CarId;
    String message;
    LocalDate startDate;
    LocalDate endDate;
}
