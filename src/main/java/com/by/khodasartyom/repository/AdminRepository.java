package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.admin.Admin;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin,Long> {
    Optional<Admin> findByEmail(String email);

}
