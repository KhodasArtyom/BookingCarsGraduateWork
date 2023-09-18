package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.repository.AdminRepository;
import com.by.khodasartyom.repository.CarRepository;
import com.by.khodasartyom.security.AdminPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarAdminServiceImpl implements CarAdminService {
    private final CarRepository carRepository;
    private final AdminRepository adminRepository;

    @Override
    @Transactional
    public CarsDto create(CarsDto dto, AdminPrincipal principal) {
        adminRepository.getReferenceById(principal.getId());
        Cars car = new Cars()
                .setBrand(dto.getBrand())
                .setModel(dto.getModel())
                .setYear_of_issue(dto.getYear_of_issue())
                .setPrice(dto.getPrice())
                .setBookingStatus(dto.getReservation_status());


        return CarsDto.from(car);
    }

    @Override
    @Transactional
    public void remove(long id, CarsDto dto, AdminPrincipal principal) {
        adminRepository.getReferenceById(principal.getId());
        Cars car = carRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Such car is not found"));
        carRepository.remove(car);

    }

    @Override
    @Transactional
    public CarsDto update(long id, CarsDto dto, AdminPrincipal adminPrincipal) {
        adminRepository.getReferenceById(adminPrincipal.getId());
        Cars car = carRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Such car is not found "));
        car
                .setBrand(dto.getBrand())
                .setModel(dto.getModel())
                .setYear_of_issue(dto.getYear_of_issue())
                .setPrice(dto.getPrice());
        return CarsDto.from(car);
    }


}
