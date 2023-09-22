package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.admin.Admin;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin,Long>{


    Optional<Admin> findByEmail(String email);
}
