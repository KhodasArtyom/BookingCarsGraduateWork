package com.by.khodasartyom.controller;

import com.by.khodasartyom.model.car.CarDto;
import com.by.khodasartyom.model.car.CarUpdateDto;
import com.by.khodasartyom.model.security.AdminPrincipal;
import com.by.khodasartyom.service.CarAdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-api")
@RequiredArgsConstructor
@Tag(name = "Admin API", description = "Admin's opportunities")
public class AdminApiController {

    private final CarAdminService carAdminService;

    public CarDto create(@RequestBody CarUpdateDto dto,
                         @AuthenticationPrincipal AdminPrincipal principal) {

            return carAdminService.create(dto,principal);
    }
}
