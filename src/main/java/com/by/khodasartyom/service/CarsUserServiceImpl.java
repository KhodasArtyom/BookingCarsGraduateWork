package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.repository.BookingRepository;
import com.by.khodasartyom.repository.CarsRepository;
import com.by.khodasartyom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarsUserServiceImpl implements CarsUserService
{private final CarsRepository carsRepository;
    private final UsersRepository usersRepository;
    private final BookingRepository bookingRepository;

    public static final int CARS_PAGE_SIZE = 10;

    @Override
    public List<CarsDto> seeAllCars(int pageNumber) {
        return carsRepository.getAllCars(CARS_PAGE_SIZE,pageNumber)
                .stream()
                .map(CarsDto::from)
                .toList();

    }
}
