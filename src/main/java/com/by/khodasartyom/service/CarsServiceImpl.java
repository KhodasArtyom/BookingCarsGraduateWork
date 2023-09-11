package com.by.khodasartyom.service;

import com.by.khodasartyom.exception.BusinessException;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.repository.CarsRepository;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;

    @Override
    public List<CarsDto> getCarsByBrand(String brand) {
        List<Cars> carsList = carsRepository.findByBrand(brand);
        if (carsList.isEmpty()) {
            throw new BusinessException("There is no such brand");

        } else {
            List<CarsDto> carsDtos = new ArrayList<>();
            for (Cars cars : carsList) {
                CarsDto carsDto = new CarsDto(cars.getId_cars(),
                        cars.getBrand(),
                        cars.getModel(),
                        cars.getYear_of_issue(),
                        cars.getPrice());
                carsDtos.add(carsDto);
            }
            return carsDtos;
        }
    }

    @Override
    public List<CarsDto> getCarsByBrandAndModel(String brand, String model) {
        return null;
    }

    @Override
    public List<CarsDto> getCarsByYearOfIssue(int yearOfIssue) {
        return null;
    }


}
