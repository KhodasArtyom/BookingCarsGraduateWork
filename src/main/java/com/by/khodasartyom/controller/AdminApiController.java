package com.by.khodasartyom.controller;

import com.by.khodasartyom.model.car.CarDto;
import com.by.khodasartyom.model.car.CarUpdateDto;
import com.by.khodasartyom.model.carReservation.CarReservationDto;
import com.by.khodasartyom.model.security.AdminPrincipal;
import com.by.khodasartyom.service.CarAdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin-api")
@RequiredArgsConstructor
@Tag(name = "Admin API", description = "Admin's opportunities")
public class AdminApiController {

    private final CarAdminService carAdminService;

    @PostMapping("/createCar")
    public CarDto create(@RequestBody CarUpdateDto dto,
                         @AuthenticationPrincipal AdminPrincipal principal) {

            return carAdminService.create(dto,principal);
    }

    @PostMapping("/updateCar/{carId}")
    public CarDto updateCar(@PathVariable long carId,@RequestBody CarUpdateDto dto  ,@AuthenticationPrincipal AdminPrincipal principal){

        return carAdminService.update(carId,dto,principal);
    }

    @GetMapping("/cars")
    public List<CarDto> getPageOfCarOfAdmin(@RequestParam int page,@AuthenticationPrincipal AdminPrincipal principal){
        return carAdminService.getPageOfCars(page,principal);
    }

    @GetMapping
    public List<CarReservationDto> getPageOfCarsReservations(@RequestParam int page,@AuthenticationPrincipal AdminPrincipal principal){

        return carAdminService.getCarReservationListWithCarsAndUsers(page,principal);
    }
}
