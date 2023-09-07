package com.by.khodasartyom.repository;

import com.by.khodasartyom.entity.users.Users;


import java.util.List;
import java.util.Optional;

public interface UsersRepo extends BaseRepository<Users, Long> {


    List<Users> findByEmail(String email);


    List<Users> findByName(String name);
}
