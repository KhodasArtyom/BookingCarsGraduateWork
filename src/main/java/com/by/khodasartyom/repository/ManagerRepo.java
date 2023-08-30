package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.Manager;

import java.util.Optional;

public interface ManagerRepo extends BaseRepository<Manager,Long>{


    Optional<Manager> findById(String email);
}
