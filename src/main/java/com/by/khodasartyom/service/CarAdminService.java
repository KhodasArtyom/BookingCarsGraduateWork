package com.by.khodasartyom.service;

import com.by.khodasartyom.model.entityandDto.cars.Cars;
import com.by.khodasartyom.model.entityandDto.cars.CarsDto;
import com.by.khodasartyom.security.AdminPrincipal;

import java.util.List;


public interface CarAdminService {

    CarsDto create(CarsDto dto, AdminPrincipal principal);

     void remove(long id, CarsDto dto, AdminPrincipal principal);

     CarsDto update(long id,CarsDto dto,AdminPrincipal adminPrincipal);










}
