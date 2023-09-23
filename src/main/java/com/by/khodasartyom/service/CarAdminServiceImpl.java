package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.admin.Admin;
import com.by.khodasartyom.model.car.Car;
import com.by.khodasartyom.model.car.CarDto;
import com.by.khodasartyom.model.car.CarUpdateDto;
import com.by.khodasartyom.model.carReservation.CarReservationDto;
import com.by.khodasartyom.model.security.AdminPrincipal;
import com.by.khodasartyom.repository.AdminRepository;
import com.by.khodasartyom.repository.CarRepository;
import com.by.khodasartyom.repository.CarReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarAdminServiceImpl implements CarAdminService {

    private final CarRepository carRepository;
    private final CarReservationRepository carReservationRepository;
    private final AdminRepository adminRepository;

    public static final int CARS_PAGE_SIZE = 10;
    public static final int CARS_RES_SIZE = 5;

    @Override
    @Transactional
    public CarDto getCarById(long id, AdminPrincipal adminPrincipal) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new BusinessException("There is no such car"));
        validateAccess(car, adminPrincipal);
        return CarDto.from(car);
    }

    @Override
    @Transactional
    public CarDto create(CarUpdateDto dto, AdminPrincipal adminPrincipal) {
        Instant createdAt = Instant.now();
        Admin admin = adminRepository.getReferenceById(adminPrincipal.getId());

        Car car = new Car()
                .setAdmin(admin)
                .setBrand(dto.getBrand())
                .setModel(dto.getModel())
                .setPrice(dto.getPrice())
                .setCreatedAt(createdAt)
                .setActive_status(dto.isStatusActive());
        carRepository.create(car);
        return CarDto.from(car);
    }

    @Override
    @Transactional
    public CarDto update(long id, CarUpdateDto dto, AdminPrincipal adminPrincipal) {
        return null;
    }

    @Override
    @Transactional
    public List<CarDto> getPageOfCars(int pageNumber, AdminPrincipal adminPrincipal) {
        return null;
    }

    @Override
    @Transactional
    public List<CarReservationDto> getCarReservationListWithCarsAndUsers(int pageNumber, AdminPrincipal adminPrincipal) {
        return null;
    }

    private void validateAccess(Car car, AdminPrincipal adminPrincipal) {
        long authenticated = adminPrincipal.getId();
        long ownerId = car.getAdmin().getId();
        if (authenticated != ownerId) {
            throw new BusinessException("Access denied");
        }
    }
}
