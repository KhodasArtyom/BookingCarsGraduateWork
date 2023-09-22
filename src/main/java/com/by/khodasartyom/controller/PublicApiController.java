package com.by.khodasartyom.controller;


import com.by.khodasartyom.model.entityandDto.admin.AdminSignInDto;
import com.by.khodasartyom.model.entityandDto.admin.AdminSignUpDto;
import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.model.security.AccessToken;
import com.by.khodasartyom.service.AdminService;
import com.by.khodasartyom.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public-api")
@RequiredArgsConstructor
@Tag(name = "Public API",description = "Access without authentication")
public class PublicApiController {

    private final AdminService adminService;
    private final UserService userService;
    private final CarAdminService carAdminService;


    @PostMapping("/admins")
    public AccessToken signUpAdmin(@RequestBody AdminSignUpDto dto) {
        return adminService.signUp(dto);
    }

    @PostMapping("/admins/access-tokens")
    public AccessToken signInAdmin(@RequestBody AdminSignInDto dto) {
        return adminService.signIn(dto);
    }

    @GetMapping("/cars")
    public List<CarsDto> seeAllCars(){
        return carAdminService.findAllCars();
    }
}
