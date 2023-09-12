package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.entityandDto.booking.Booking;
import com.by.khodasartyom.model.entityandDto.booking.BookingDto;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsShortDto;
import com.by.khodasartyom.model.entityandDto.users.UserDto;
import com.by.khodasartyom.model.entityandDto.users.Users;
import com.by.khodasartyom.repository.BookingRepository;
import com.by.khodasartyom.repository.CarsRepository;
import com.by.khodasartyom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarsUserServiceImpl implements CarsUserService {
    private final CarsRepository carsRepository;
    private final UsersRepository usersRepository;
    private final BookingRepository bookingRepository;

    public static final int CARS_PAGE_SIZE = 10;

    @Override
    public List<CarsDto> seeAllCars(int pageNumber) {
        return carsRepository.getAllCars(CARS_PAGE_SIZE, pageNumber)
                .stream()
                .map(CarsDto::from)
                .toList();

    }

    @Override
    public Optional<CarsShortDto> getCarById(long id) {
        return carsRepository.findById(id)
                .stream()
                .map(CarsShortDto::from)
                .findFirst();
    }

    @Override
    public List<CarsShortDto> getListOfCarsByBrand(String brand, int pageNumber) {
        String brandQuery = "$" + brand + "$";

        return carsRepository.findAllCarsByBrand(brandQuery, CARS_PAGE_SIZE, pageNumber)
                .stream()
                .map(CarsShortDto::from)
                .toList();
    }

    @Override
    public BookingDto bookCar(Long userId, Long carId, LocalDateTime startOfLease, LocalDateTime endOfLease) {
        Optional<Users> user = usersRepository.findById(userId);
        Optional<Cars> car = carsRepository.findById(carId);
        if (user.isEmpty() || car.isEmpty()) {
            throw new BusinessException("There is no such user or car");

        }
        Booking booking = new Booking();
        booking.setUser(user.get());
        booking.setCar(car.get());
        booking.setStart_of_lease(startOfLease);
        booking.setEnd_of_lease(endOfLease);
        BigDecimal price  = calculateBookingPrice(startOfLease,endOfLease);
        booking.setPrice(price);

        return null;
    }

    private BigDecimal calculateBookingPrice(LocalDateTime startOfLease, LocalDateTime endOfLease) {
        long hoursBetween = Duration.between(startOfLease, endOfLease).toHours();
        BigDecimal priceInHour = BigDecimal.valueOf(15.5);
        BigDecimal totalPrice = priceInHour.multiply(BigDecimal.valueOf(hoursBetween));


        return totalPrice;
    }

}
