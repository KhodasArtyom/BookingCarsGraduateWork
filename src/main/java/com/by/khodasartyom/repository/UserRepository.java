package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.users.User;


import java.util.Optional;

public interface UserRepository extends BaseRepository<User,Long> {

    Optional<User> findByEmail(String email);


}
