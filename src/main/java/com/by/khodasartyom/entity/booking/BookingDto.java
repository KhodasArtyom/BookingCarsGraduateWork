package com.by.khodasartyom.entity.booking;

import com.by.khodasartyom.entity.cars.CarsDto;
import com.by.khodasartyom.entity.users.UsersDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BookingDto {

    private Long id;
    private Date startDate;
    private Date endDate;
    private UsersDto user;
    private CarsDto car;
}
