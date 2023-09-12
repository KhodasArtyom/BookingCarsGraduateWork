package com.by.khodasartyom.model.entityandDto.booking;

import com.by.khodasartyom.model.entityandDto.users.Users;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class CreateBookingDto {
    long carsId;
    LocalDateTime start_of_issue;
    LocalDateTime end_of_issue;


}
