package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.users.Users;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends BaseRepository<Users, Long> {


    Optional<Users> findByEmail(String email);


    List<Users> findByName(String name);
}
