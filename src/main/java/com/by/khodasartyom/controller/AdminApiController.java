package com.by.khodasartyom.controller;

import com.by.khodasartyom.model.entityandDto.admin.AdminShortDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsOwnDto;
import com.by.khodasartyom.model.entityandDto.cars.CarsUpdateDto;
import com.by.khodasartyom.model.security.AdminPrincipal;
import com.by.khodasartyom.service.AdminService;
import com.by.khodasartyom.service.CarsAdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin-api")
@RequiredArgsConstructor
@Tag(name = "Admin API", description = "Admin")
public class AdminApiController {

    private final AdminService adminService;
    private final CarsAdminService carsAdminService;

    public CarsOwnDto createCar(@RequestBody CarsUpdateDto dto,
                                @AuthenticationPrincipal AdminPrincipal principal) {
        return carsAdminService.createCar(dto, principal);
    }




}
