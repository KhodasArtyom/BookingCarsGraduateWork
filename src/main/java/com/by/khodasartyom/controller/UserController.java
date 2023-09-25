package com.by.khodasartyom.controller;

import com.by.khodasartyom.model.car.CarDateDto;
import com.by.khodasartyom.model.car.CarPriceDto;
import com.by.khodasartyom.model.carReservation.CarReservationCreateReservationDto;
import com.by.khodasartyom.model.carReservation.CarReservationShortToResDto;
import com.by.khodasartyom.model.security.UserPrincipal;
import com.by.khodasartyom.service.CarUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user-api")
@RequiredArgsConstructor
@Tag(name = "User API", description = "User's opportunities")
public class UserController {
    private final CarUserService carUserService;

    @GetMapping("/cars-date")
    public List<CarDateDto> findByDate(
            @RequestParam LocalDate startDate
            , @RequestParam LocalDate endDate
            , @AuthenticationPrincipal UserPrincipal principal
            , @RequestParam int pageNumber) {

        return carUserService.getAvailableCarsOnUserDate(startDate, endDate, principal, pageNumber);
    }

    public List<CarPriceDto> findWithLowPrices(@AuthenticationPrincipal UserPrincipal principal
            , @RequestParam int pageNumber) {

        return carUserService.findPageActiveStatusWithLowPrice(principal, pageNumber);
    }

    @PostMapping("/create-reservation")
    public CarReservationShortToResDto createReservation(@RequestBody CarReservationCreateReservationDto dto
            , @AuthenticationPrincipal UserPrincipal principal) {

        return carUserService.sendRequestForReservation(dto, principal);
    }


}
