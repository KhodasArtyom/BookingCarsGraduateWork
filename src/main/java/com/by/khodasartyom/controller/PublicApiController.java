package com.by.khodasartyom.controller;


import com.by.khodasartyom.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public-api")
@RequiredArgsConstructor
@Tag(name = "Public API",description = "Access enable to all,without authentication")
public class PublicApiController {
    private final AdminService adminService;
    private final UserServi
}
