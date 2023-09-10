package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.admin.Admin;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AdminRepository extends BaseRepository<Admin,Long> {

    Optional<Admin> findByEmail(String email);
}
