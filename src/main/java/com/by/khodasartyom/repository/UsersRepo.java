package com.by.khodasartyom.repository;

import com.by.khodasartyom.entity.users.Users;


import java.util.List;
import java.util.Optional;

public interface UsersRepo extends BaseRepository<Users, Long> {

    @Override
    Optional<Users> findById(Long id);


    @Override
    default void create(Users entity) {

    }

    @Override
    default void remove(Users entity) {

    }

    List<Users> findByEmail(String email);



    List<Users> findByName(String name);
}
