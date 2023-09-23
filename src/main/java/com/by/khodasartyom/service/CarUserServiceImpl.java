package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.car.Car;
import com.by.khodasartyom.model.car.CarDateDto;
import com.by.khodasartyom.model.car.CarPriceDto;
import com.by.khodasartyom.model.car.CarShortDto;
import com.by.khodasartyom.model.carReservation.CarReservation;
import com.by.khodasartyom.model.carReservation.CarReservationCreateReservationDto;
import com.by.khodasartyom.model.carReservation.CarReservationShortToResDto;
import com.by.khodasartyom.model.security.UserPrincipal;
import com.by.khodasartyom.model.user.User;
import com.by.khodasartyom.repository.CarRepository;
import com.by.khodasartyom.repository.CarReservationRepository;
import com.by.khodasartyom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarUserServiceImpl implements CarUserService{
    public final int CARS_PAGE_SIZE = 10;

    private final CarRepository carRepository;
    private final CarReservationRepository carReservationRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<CarShortDto> getPageByBrandQuery(String brandQuery, int pageNumber) {
        String dbBrandQuery = "$"  + brandQuery + "$";
        return carRepository.findPageOfActiveAdminsCarsByBrand(dbBrandQuery,CARS_PAGE_SIZE,pageNumber)
                .stream()
                .map(CarShortDto::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarPriceDto> findPageActiveStatusWithLowPrice(UserPrincipal userPrincipal,int pageNumber) {
        return carRepository.findPageActiveCarByLowPrice(CARS_PAGE_SIZE,pageNumber)
                .stream()
                .map(CarPriceDto::from)
                .toList();
    }

    @Override
    @Transactional
    public List<CarDateDto> getAvailableCarsOnUserDate(LocalDate startDate, LocalDate endDate, UserPrincipal userPrincipal,int pageNumber) {
        return carRepository.getAvailableCarsInDateRange(startDate,endDate,CARS_PAGE_SIZE,pageNumber)
                .stream()
                .map(CarDateDto::from)
                .toList();
    }

    @Override
    @Transactional
    public CarReservationShortToResDto sendRequestForReservation(CarReservationCreateReservationDto dto, UserPrincipal userPrincipal) {
       Car car = carRepository.findById(dto.getCarId())
               .orElseThrow(()->new BusinessException("There is no such reservation"));

        User user = userRepository.getReferenceById(userPrincipal.getId());
        Instant createdAt = Instant.now();
        LocalDate start = dto.getStartDate();
        LocalDate end = dto.getEndDate();
        CarReservation carReservation = new CarReservation()
                .setUser(user)
                .setCar(car)
                .setMessage(dto.getMessage())
                .setStartDate(start)
                .setEndDate(end)
                .setCreatedAt(createdAt);
        carReservationRepository.create(carReservation);
        return CarReservationShortToResDto.from(carReservation);
    }
}
