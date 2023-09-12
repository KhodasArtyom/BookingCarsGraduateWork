package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.entityandDto.admin.Admin;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsOwnDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsUpdateDto;
import com.by.khodasartyom.model.security.AdminPrincipal;
import com.by.khodasartyom.repository.AdminRepository;
import com.by.khodasartyom.repository.BookingRepository;
import com.by.khodasartyom.repository.CarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CarsAdminServiceImpl implements CarsAdminService{
    private final CarsRepository carsRepository;
    private final BookingRepository bookingRepository;
    private AdminRepository adminRepository;

    public static final int CARS_PAGE_SIZE = 10;



    @Override
    public CarsOwnDto createCar(CarsUpdateDto dto, AdminPrincipal adminPrincipal) {
        Admin admin = adminRepository.getReferenceById(adminPrincipal.getId());

        Cars car = new Cars()
                .setAdmin(admin)
                .setBrand(dto.getBrand())
                .setModel(dto.getModel())
                .setYear_of_issue(dto.getYear_of_issue())
                .setPrice(dto.getPrice())
                .setBookingStatus(dto.isBookingStatus());
        return CarsOwnDto.from(car);
    }

    @Override
    public CarsOwnDto updateInfoAboutCar(long id, CarsUpdateDto carsUpdateDto, AdminPrincipal adminPrincipal) {
       Cars car = carsRepository.findById(id).orElseThrow(()->new BusinessException("Impossible to find the car"));
       validateAccess(car,adminPrincipal);
       car.setBrand(carsUpdateDto.getBrand());
       car.setModel(car.getModel());
       car.setYear_of_issue(car.getYear_of_issue());
       car.setPrice(carsUpdateDto.getPrice());
       car.setBookingStatus(car.isBookingStatus());


        return CarsOwnDto.from(car);
    }

    @Override
    public CarsOwnDto getCarsOwnById(long id, AdminPrincipal adminPrincipal) {
        Cars car = carsRepository.findById(id)
                .orElseThrow(()->new BusinessException("There is no such car id"));
        return CarsOwnDto.from(car);
    }

    @Override
    public List<CarsDto> getPageOwnCars(int pageNumber) {

        return carsRepository.getAllCars(CARS_PAGE_SIZE,pageNumber)
                .stream()
                .map(CarsDto::from)
                .toList();
    }

    @Override
    public void deleteTheCar(long id, AdminPrincipal adminPrincipal) {
        Cars car = carsRepository.findById(id).orElseThrow(()->new BusinessException("Can't find such id car"));
        validateAccess(car,adminPrincipal);
        carsRepository.remove(car);
    }

    private void validateAccess(Cars car,AdminPrincipal adminPrincipal){
        long authenticatedId = adminPrincipal.getId();
        long ownerId =car.getAdmin().getId();
        if(authenticatedId !=ownerId){
            throw new BusinessException("Access denied");
        }
    }
}
