package com.by.khodasartyom.controller;

import com.by.khodasartyom.model.admin.AdminSignInDto;
import com.by.khodasartyom.model.admin.AdminSignUpDto;
import com.by.khodasartyom.model.car.CarShortDto;
import com.by.khodasartyom.model.security.AccessToken;
import com.by.khodasartyom.model.user.UserSignInDto;
import com.by.khodasartyom.model.user.UserSignUpDto;
import com.by.khodasartyom.service.AdminService;
import com.by.khodasartyom.service.CarUserService;
import com.by.khodasartyom.service.CarUserServiceImpl;
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

    private final UserService userService;
    private final CarUserService carUserService;
    private final AdminService adminService;

    @PostMapping("/user-signUp")
    public AccessToken signUpUser(@RequestBody UserSignUpDto signUpDto) {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/user-signIn")
    public AccessToken signInUser(@RequestBody UserSignInDto signInDto) {
        return userService.signIn(signInDto);
    }


    @PostMapping("/admin-signUp")
    public AccessToken signUpAdmin(@RequestBody AdminSignUpDto signUpDto){
        return adminService.signUp(signUpDto);
    }

    @PostMapping("/admin-signIn")
    public AccessToken signInAdmin(AdminSignInDto signInDto){
        return adminService.signIn(signInDto);
    }

    public List<CarShortDto> getPageByBrand(@RequestParam String query,@RequestParam int pageNumber){

        return carUserService.getPageByBrandQuery(query, pageNumber);
    }

}
