package com.by.khodasartyom.model.carReservation;

import com.by.khodasartyom.model.car.CarDto;
import com.by.khodasartyom.model.user.UserDto;
import lombok.Value;

import java.time.Instant;


@Value
public class CarReservationDto {

    long id;
    CarDto carDto;
    UserDto userDto;
    String message;
    Instant createdAt;

    public static CarReservationDto from(CarReservation carReservation){

        return new CarReservationDto(
                carReservation.getId(),
                CarDto.from(carReservation.getCar()),
                UserDto.from(carReservation.getUser()),
                carReservation.getMessage(),
                carReservation.getCreatedAt()
        );
    }
}
