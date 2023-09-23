package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.carReservation.CarReservation;

import java.util.List;
import java.util.Optional;

public interface CarReservationRepository extends BaseRepository<CarReservation,Long>{

    Optional<CarReservation> findByCarAndUser(long carId,long userId);

    List<CarReservation> findByCarAdminAndUser(long adminId,long userId,int pageSize,int pageNumber);

    List<CarReservation> findPageByUser(long userId,int pageSize,int pageNumber);

    List<CarReservation> findPageByAdminWithCarAndUser(long adminId,int pageSize,int pageNumber);




}
